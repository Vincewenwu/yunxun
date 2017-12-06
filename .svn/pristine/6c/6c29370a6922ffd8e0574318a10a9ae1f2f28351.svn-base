package com.vision.edu.entity.member;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 评论记录
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_comment")
public class MemComment extends Model<MemComment> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 评论人ID
	 */
	@TableField("member_id")
	private String memberId;
	/**
	 * 评论内容
	 */
	private String comment;
	/**
	 * 父ID
	 */
	@TableField("father_id")
	private String fatherId;
	/**
	 * 来源ID
	 */
	@TableField("source_id")
	private String sourceId;
	/**
	 * 评论类型
	 */
	@TableField("comment_type")
	private Integer commentType;
	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private Date createTime;

	/**
	 * 修改时间
	 */
	@TableField("update_time")
	private Date updateTime;

	/**
	 * 修改人
	 */
	@TableField("update_man")
	private String updateMan;

	/**
	 * 点赞数
	 */
	@TableField("point_count")
	private Integer pointCount;
	/**
	 * 回复数
	 */
	@TableField("reply_count")
	private Integer replyCount;

	/**
	 * 0-未删除，1-已删除
	 */
	@TableField("delete_flag")
	private Integer deleteFlag;
	/**
	 * 回复列表
	 */
	@TableField(exist = false)
	private List<MemComment> replys;
	/**
	 * 评论人/回复人
	 */
	@TableField(exist = false)
	private String commentMan;
	/**
	 * 评论人头像
	 */
	@TableField(exist = false)
	private String commentManHeadImgUrl;
	/**
	 * 被回复人
	 */
	@TableField(exist = false)
	private String beCommentMan;

	/**
	 * 是否可以删除标记
	 */
	@TableField(exist = false)
	private Integer editFlag;

	/**
	 * 当前成员点赞记录id
	 */
	@TableField(exist = false)
	private String praiseId;

	/**
	 * 当前成员点赞状态
	 */
	@TableField(exist = false)
	private String cancelNo;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public Integer getCommentType() {
		return commentType;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateMan() {
		return updateMan;
	}

	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public List<MemComment> getReplys() {
		return replys;
	}

	public void setReplys(List<MemComment> replys) {
		this.replys = replys;
	}

	public String getCommentMan() {
		return commentMan;
	}

	public void setCommentMan(String commentMan) {
		this.commentMan = commentMan;
	}

	public String getBeCommentMan() {
		return beCommentMan;
	}

	public void setBeCommentMan(String beCommentMan) {
		this.beCommentMan = beCommentMan;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Integer getPointCount() {
		return pointCount;
	}

	public void setPointCount(Integer pointCount) {
		this.pointCount = pointCount;
	}

	public String getCommentManHeadImgUrl() {
		return commentManHeadImgUrl;
	}

	public void setCommentManHeadImgUrl(String commentManHeadImgUrl) {
		this.commentManHeadImgUrl = commentManHeadImgUrl;
	}

	public Integer getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(Integer editFlag) {
		this.editFlag = editFlag;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public String getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}

	public String getCancelNo() {
		return cancelNo;
	}

	public void setCancelNo(String cancelNo) {
		this.cancelNo = cancelNo;
	}

}
