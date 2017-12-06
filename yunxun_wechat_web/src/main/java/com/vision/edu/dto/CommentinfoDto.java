package com.vision.edu.dto;

/**
 * 
 * @author lichenglong
 * @date 2017年7月23日 下午12:08:55
 * @version 1.0
 */
public class CommentinfoDto {
	
	private String memberId;//评论人ID
	private String memComment;//评论内容
	private String fatherId;//父ID
	private String sourceId;//来源ID
	private String commentType;//评论类型
	private String createTime;//创建时间
	private String sysUserheadPortrait;//用户头像
	private String sysUserName;//用户名称
	private String memMemberheadPortrait;//会员头像
	private String memMemberName;//会员名称
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemComment() {
		return memComment;
	}
	public void setMemComment(String memComment) {
		this.memComment = memComment;
	}
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getCommentType() {
		return commentType;
	}
	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getSysUserheadPortrait() {
		return sysUserheadPortrait;
	}
	public void setSysUserheadPortrait(String sysUserheadPortrait) {
		this.sysUserheadPortrait = sysUserheadPortrait;
	}
	public String getSysUserName() {
		return sysUserName;
	}
	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}
	public String getMemMemberheadPortrait() {
		return memMemberheadPortrait;
	}
	public void setMemMemberheadPortrait(String memMemberheadPortrait) {
		this.memMemberheadPortrait = memMemberheadPortrait;
	}
	public String getMemMemberName() {
		return memMemberName;
	}
	public void setMemMemberName(String memMemberName) {
		this.memMemberName = memMemberName;
	}
	@Override
	public String toString() {
		return "CommentinfoDto [memberId=" + memberId + ", memComment=" + memComment + ", fatherId=" + fatherId
				+ ", sourceId=" + sourceId + ", commentType=" + commentType + ", createTime=" + createTime
				+ ", sysUserheadPortrait=" + sysUserheadPortrait + ", sysUserName=" + sysUserName
				+ ", memMemberheadPortrait=" + memMemberheadPortrait + ", memMemberName=" + memMemberName + "]";
	}
}
