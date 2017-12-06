package com.vision.edu.service.base.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vision.edu.entity.base.BaseWechat;
import com.vision.edu.mapper.base.BaseWechatMapper;
import com.vision.edu.service.base.IBaseWechatService;

import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * <p>
 * 微信信息 服务实现类
 * </p>
 *
 * @author XieFan
 * @since 2017-07-14
 */
@Service
public class BaseWechatServiceImpl extends ServiceImpl<BaseWechatMapper, BaseWechat> implements IBaseWechatService {

	private static final Logger LOG = LoggerFactory.getLogger(BaseWechatServiceImpl.class);

	@Override
	public BaseWechat doCheckWechat(WxMpOAuth2AccessToken oAuth2AccessToken) {
		BaseWechat baseWechat = new BaseWechat();
		baseWechat.setUnionId(oAuth2AccessToken.getUnionId());
		baseWechat = baseMapper.selectOne(baseWechat);
		return baseWechat;
	}

	@Override
	public BaseWechat addWechat(WxMpUser wxMpUser) {
		BaseWechat baseWechat = BaseWechat.fromJson(JSONObject.toJSONString(wxMpUser));
		//防重复提交
		BaseWechat wechat = new BaseWechat();
		wechat.setUnionId(baseWechat.getUnionId());
		BaseWechat one = baseMapper.selectOne(wechat);
		if (one == null) {
			baseMapper.insert(baseWechat);
		} else {
			Wrapper<BaseWechat> wrapper = new EntityWrapper<>();
			wrapper.where("unionId={0}", baseWechat.getUnionId());
			baseMapper.update(baseWechat, wrapper);
		}
		return baseWechat;
	}

}
