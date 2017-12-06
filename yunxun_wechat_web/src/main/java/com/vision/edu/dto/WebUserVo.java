package com.vision.edu.dto;

import com.vision.edu.entity.base.BaseBaby;
import com.vision.edu.entity.base.BaseMember;
import com.vision.edu.entity.base.BaseWechat;

/**
 * @author zhangfeihong
 * @date 2017年7月22日 上午10:51:36
 * @version 1.0
 */
public class WebUserVo {

	/**
	 * 游客
	 */
	public static final Integer YOUKE = 0;
	/**
	 * 报名中的家长
	 */
	public static final Integer JZ_BMZ = 1;
	/**
	 * 已报名家长
	 */
	public static final Integer JZ_YBM = 2;
	/**
	 * 老师
	 */
	public static final Integer LS = 3;
	/**
	 * 园长
	 */
	public static final Integer YZ = 4;
	/**
	 * 平台管理员
	 */
	public static final Integer PTGL = 5;

	private BaseWechat baseWechat;
	/**
	 * 用户基本信息
	 */
	private BaseMember baseMember;

	/**
	 * 宝贝信息
	 */
	private BaseBaby baseBaby;

	/**
	 * 前端用户信息
	 */
	private Object user;
	/**
	 * 用户类型
	 */
	private Integer userFlag;

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	public Integer getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(Integer userFlag) {
		this.userFlag = userFlag;
	}

	public BaseMember getBaseMember() {
		return baseMember;
	}

	public void setBaseMember(BaseMember baseMember) {
		this.baseMember = baseMember;
	}

	public BaseWechat getBaseWechat() {
		return baseWechat;
	}

	public void setBaseWechat(BaseWechat baseWechat) {
		this.baseWechat = baseWechat;
	}

	public BaseBaby getBaseBaby() {
		return baseBaby;
	}

	public void setBaseBaby(BaseBaby baseBaby) {
		this.baseBaby = baseBaby;
	}

}
