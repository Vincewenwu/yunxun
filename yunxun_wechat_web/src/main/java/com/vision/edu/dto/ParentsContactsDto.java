package com.vision.edu.dto;

/**
 * 家长通信录
 * @author lichenglong
 * @date 2017年7月25日 上午8:30:52
 * @version 1.0
 */
public class ParentsContactsDto {

	private String memberId;//家长ID
	private String headPortrait;//头像
	private String memberName;//姓名
	private String babyId;//宝贝ID
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBabyId() {
		return babyId;
	}
	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}
	@Override
	public String toString() {
		return "parentsContactsDto [memberId=" + memberId + ", headPortrait=" + headPortrait + ", memberName="
				+ memberName + ", babyId=" + babyId + "]";
	}
}
