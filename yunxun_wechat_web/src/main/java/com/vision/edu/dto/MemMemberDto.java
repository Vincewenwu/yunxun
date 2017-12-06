package com.vision.edu.dto;

import java.util.Date;

/**
 * 
 * @author lichenglong
 * @date 2017年7月14日 下午5:21:19
 * @version 1.0
 */
public class MemMemberDto {
	
	private String id;//主键
	private String baseMemberId;//用户基本信息ID
	private Integer disableFlag;//停用否
	private Date lastLandingTime;//最后登陆时间
	private String schoolId;//园校id
	private String unionid;//UnitionidID
	private String openid;//OpenId
	private Integer sex;//性别
	private String memberName;//姓名
	private String phoneNum;//手机号码
	private String address;//地址
	private String headPortrait;//头像
	private String homePhone;//家庭电话
	private String intro;//个人简介
	private String email;//邮箱
	private String qq;//QQ
	private String idCardNum;//身份证号
	private Date birth;//出生日期
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBaseMemberId() {
		return baseMemberId;
	}
	public void setBaseMemberId(String baseMemberId) {
		this.baseMemberId = baseMemberId;
	}
	public Integer getDisableFlag() {
		return disableFlag;
	}
	public void setDisableFlag(Integer disableFlag) {
		this.disableFlag = disableFlag;
	}
	public Date getLastLandingTime() {
		return lastLandingTime;
	}
	public void setLastLandingTime(Date lastLandingTime) {
		this.lastLandingTime = lastLandingTime;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getIdCardNum() {
		return idCardNum;
	}
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	@Override
	public String toString() {
		return "MemMemberInfo [id=" + id + ", baseMemberId=" + baseMemberId + ", disableFlag=" + disableFlag
				+ ", lastLandingTime=" + lastLandingTime + ", schoolId=" + schoolId + ", unionid=" + unionid
				+ ", openid=" + openid + ", sex=" + sex + ", memberName=" + memberName + ", phoneNum=" + phoneNum
				+ ", address=" + address + ", headPortrait=" + headPortrait + ", homePhone=" + homePhone + ", intro="
				+ intro + ", email=" + email + ", qq=" + qq + ", idCardNum=" + idCardNum + ", birth=" + birth + "]";
	}
	
	
}
