package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import me.chanjar.weixin.common.util.ToStringUtils;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

/**
 * <p>
 * 微信信息
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_wechat")
public class BaseWechat extends Model<BaseWechat> {

	private static final long serialVersionUID = 1L;

	/**
	 * unionid（主键）
	 */
	private String unionId;
	/**
	 * openid
	 */
	private String openId;
	/**
	 * groupid
	 */
	private Integer groupId;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * headimgurl
	 */
	private String headImgUrl;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 地区
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * subscribe_time
	 */
	private Date subscribeTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 关注标记
	 */
	private Boolean subscribe;
	/**
	 * 语言
	 */
	private String language;
	/**
	 * 性别id
	 */
	private Integer sexId;

	public static BaseWechat fromJson(String json) {
		return WxMpGsonBuilder.INSTANCE.create().fromJson(json, BaseWechat.class);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImgUrl() {
		return headImgUrl;
	}

	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(Date date) {
		this.subscribeTime = date;
	}

	public Boolean getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Boolean subscribe) {
		this.subscribe = subscribe;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getSexId() {
		return sexId;
	}

	public void setSexId(Integer sexId) {
		this.sexId = sexId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Override
	protected Serializable pkVal() {
		return this.unionId;
	}

	@Override
	public String toString() {
		return ToStringUtils.toSimpleString(this);
	}

}
