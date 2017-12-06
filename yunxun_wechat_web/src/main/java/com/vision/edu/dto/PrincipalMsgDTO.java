/**
 * 
 */
package com.vision.edu.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;

/*
 *这是园长风采的模型
*@author:zyml
*@date:2017年7月6日下午5:51:33
*/
public class PrincipalMsgDTO implements Serializable{
	
	private String id;

	private String strSchoolId;  //学校id
	
	private String roleId;   //角色id
	
	private String praiseId;   //点赞id
	
	/**
	 * 用户Id
	 */
	private String userId;
	
	/**
	 * 点赞总数
	 */
	private Integer pcount;
	
	
	
	 /**
     * 角色名称
     */
	private String roleName;
	
	/**
	 * 学校名称
	 */
	private String schoolName;
	
	  /**
     * 用户姓名
     */
	private String userName;
	
	/**
     * 头像
     */
	@TableField("head_portrait")
	private String headPortrait;

	/**
     * 个人简介
     */
	private String intro;
	
	/**
	 * 当前会员点赞标记
	 */
	@TableField(exist=false)
	private Integer cancelNo;


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getHeadPortrait() {
		return headPortrait;
	}


	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}


	public String getIntro() {
		return intro;
	}


	public void setIntro(String intro) {
		this.intro = intro;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Integer getPcount() {
		return pcount;
	}


	public void setPcount(Integer pcount) {
		this.pcount = pcount;
	}
	
	 public Integer getCancelNo() {
		return cancelNo;
	}


	public void setCancelNo(Integer cancelNo) {
		this.cancelNo = cancelNo;
	}
	
	public String getStrSchoolId() {
		return strSchoolId;
	}


	public void setStrSchoolId(String strSchoolId) {
		this.strSchoolId = strSchoolId;
	}


	public String getRoleId() {
		return roleId;
	}


	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}


	public String getPraiseId() {
		return praiseId;
	}


	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

}
