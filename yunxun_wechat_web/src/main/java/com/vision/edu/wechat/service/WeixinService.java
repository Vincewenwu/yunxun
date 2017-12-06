package com.vision.edu.wechat.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.kefu.result.WxMpKfOnlineList;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.constant.WxMpEventConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vision.edu.framework.util.PropertiesUtil;
import com.vision.edu.framework.util.UploadUtil;
import com.vision.edu.wechat.config.WxMpConfig;
import com.vision.edu.wechat.handler.AbstractHandler;
import com.vision.edu.wechat.handler.KfSessionHandler;
import com.vision.edu.wechat.handler.LocationHandler;
import com.vision.edu.wechat.handler.LogHandler;
import com.vision.edu.wechat.handler.MenuHandler;
import com.vision.edu.wechat.handler.MsgHandler;
import com.vision.edu.wechat.handler.NullHandler;
import com.vision.edu.wechat.handler.StoreCheckNotifyHandler;
import com.vision.edu.wechat.handler.SubscribeHandler;
import com.vision.edu.wechat.handler.UnsubscribeHandler;

/**
 * @author Binary Wang
 */
@Service
public class WeixinService extends WxMpServiceImpl {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected LogHandler logHandler;

	@Autowired
	protected NullHandler nullHandler;

	@Autowired
	protected KfSessionHandler kfSessionHandler;

	@Autowired
	protected StoreCheckNotifyHandler storeCheckNotifyHandler;

	@Autowired
	private WxMpConfig wxConfig;

	@Autowired
	private LocationHandler locationHandler;

	@Autowired
	private MenuHandler menuHandler;

	@Autowired
	private MsgHandler msgHandler;

	@Autowired
	private UnsubscribeHandler unsubscribeHandler;

	@Autowired
	private SubscribeHandler subscribeHandler;

	private WxMpMessageRouter router;

	@PostConstruct
	public void init() {
		final WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId(this.wxConfig.getAppid());// 设置微信公众号的appid
		config.setSecret(this.wxConfig.getAppsecret());// 设置微信公众号的app corpSecret
		config.setToken(this.wxConfig.getToken());// 设置微信公众号的token
		config.setAesKey(this.wxConfig.getAesKey());// 设置消息加解密密钥
		config.setOauth2redirectUri(this.wxConfig.getOauth2AuthorizationUrl());// 设置oauth2用户授权重定向url
		super.setWxMpConfigStorage(config);

		this.refreshRouter();
	}

	private void refreshRouter() {
		final WxMpMessageRouter newRouter = new WxMpMessageRouter(this);

		// 记录所有事件的日志
		newRouter.rule().handler(this.logHandler).next();

		// 接收客服会话管理事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxMpEventConstants.CustomerService.KF_CREATE_SESSION).handler(this.kfSessionHandler).end();
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxMpEventConstants.CustomerService.KF_CLOSE_SESSION).handler(this.kfSessionHandler).end();
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxMpEventConstants.CustomerService.KF_SWITCH_SESSION).handler(this.kfSessionHandler).end();

		// 门店审核事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxMpEventConstants.POI_CHECK_NOTIFY).handler(this.storeCheckNotifyHandler).end();

		// 自定义菜单事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.BUTTON_CLICK).handler(this.getMenuHandler()).end();

		// 点击菜单连接事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.BUTTON_VIEW).handler(this.nullHandler).end();

		// 关注事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SUBSCRIBE).handler(this.getSubscribeHandler()).end();

		// 取消关注事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_UNSUBSCRIBE).handler(this.getUnsubscribeHandler()).end();

		// 上报地理位置事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_LOCATION).handler(this.getLocationHandler()).end();

		// 接收地理位置消息
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_LOCATION).handler(this.getLocationHandler()).end();

		// 扫码事件
		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT).event(WxConsts.EVT_SCAN).handler(this.getScanHandler()).end();

		// 默认
		newRouter.rule().async(false).handler(this.getMsgHandler()).end();

		this.router = newRouter;
	}

	public WxMpXmlOutMessage route(WxMpXmlMessage message) {
		try {
			return this.router.route(message);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}

		return null;
	}

	public boolean hasKefuOnline() {
		try {
			WxMpKfOnlineList kfOnlineList = this.getKefuService().kfOnlineList();
			return kfOnlineList != null && kfOnlineList.getKfOnlineList().size() > 0;
		} catch (Exception e) {
			this.logger.error("获取客服在线状态异常: " + e.getMessage(), e);
		}

		return false;
	}

	protected MenuHandler getMenuHandler() {
		return this.menuHandler;
	}

	protected SubscribeHandler getSubscribeHandler() {
		return this.subscribeHandler;
	}

	protected UnsubscribeHandler getUnsubscribeHandler() {
		return this.unsubscribeHandler;
	}

	protected AbstractHandler getLocationHandler() {
		return this.locationHandler;
	}

	protected MsgHandler getMsgHandler() {
		return this.msgHandler;
	}

	protected AbstractHandler getScanHandler() {
		return null;
	}

	/**
	 * 微信静默授权
	 * @author zhangfeihong
	 * @date 2017年7月22日 上午8:40:07
	 * @param response
	 * @param state
	 * @param redictUrl 重定向地址
	 */
	public void doAccredit(HttpServletResponse response, String scope, String state, String redictUrl) {
		String redirectURI = super.getWxMpConfigStorage().getOauth2redirectUri() + redictUrl;
		String url = super.oauth2buildAuthorizationUrl(redirectURI, scope, state);
		try {
			logger.info("授权路径：{}", url);
			response.sendRedirect(url);
		} catch (IOException e) {
			logger.error("授权失败url：{}", url);
			e.printStackTrace();
		}
	}

	/**
	 * 根据code换取授权AccessToken
	 * @author zhangfeihong
	 * @date 2017年7月22日 下午12:03:55
	 * @param code 换取临时AccessToken的Code
	 * @return
	 * @throws WxErrorException
	 */
	public WxMpOAuth2AccessToken getWxMpOAuth2AccessToken(String code) throws WxErrorException {
		WxMpOAuth2AccessToken accessToken = super.oauth2getAccessToken(code);
		return accessToken;
	}

	/**
	 * 微信授权方式获取用户微信信息
	 * @author zhangfeihong
	 * @throws WxErrorException
	 * @date 2017年7月22日 上午8:45:54
	 */
	public WxMpUser getUserInfo(WxMpOAuth2AccessToken oAuth2AccessToken) throws WxErrorException {
		return super.oauth2getUserInfo(oAuth2AccessToken, "zh_CN");
	}
	
	/**
	 * 微信移动文件到SFTP
	 * @author XieFan
	 * @date 2017年7月26日 上午9:03:47
	 * @param mediaId
	 * @param namespace
	 * @return
	 * @throws IOException
	 */
	public String uploadImage(String mediaId, String namespace) throws IOException {
		byte[] in = null;
		File file;
		try {
			file = super.getMaterialService().mediaDownload(mediaId);
			if (file == null) {
				return null;
			}
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			bos.close();
			in = bos.toByteArray();
		} catch (WxErrorException e) {
			return null;
		}
		if (in.length > 0) {
			String dir = PropertiesUtil.getString("ftp.baseDir");
			String path = (dir + "/" + namespace).replace("//", "/");
			String uuid = UUID.randomUUID().toString();
			String postFix = ".jpg";
			String fileName = uuid + postFix;
			System.out.println("init ftp");
			UploadUtil.remove2Sftp(in, path, fileName);
			return (path + "/" + fileName).replace("//", "/").replace("\\", "/");
		} else {
			return null;
		}
	}

}
