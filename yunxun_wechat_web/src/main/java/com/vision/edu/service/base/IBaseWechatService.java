package com.vision.edu.service.base;

import com.baomidou.mybatisplus.service.IService;
import com.vision.edu.entity.base.BaseWechat;

import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * <p>
 * 微信信息 服务类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
public interface IBaseWechatService extends IService<BaseWechat> {

	/**
	 * 获取本地用户微信信息
	 * @author zhangfeihong
	 * @date 2017年7月22日 下午3:16:34
	 * @param oAuth2AccessToken
	 * @return
	 */
	BaseWechat doCheckWechat(WxMpOAuth2AccessToken oAuth2AccessToken);

	/**
	 * 新增微信用户基本信息
	 * @author zhangfeihong
	 * @date 2017年7月22日 下午3:28:05
	 * @param wxMpUser
	 * @return
	 */
	BaseWechat addWechat(WxMpUser wxMpUser);

}
