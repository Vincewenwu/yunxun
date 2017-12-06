package com.vision.edu.entity.member;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 老师家长消息业务表
 * </p>
 *
 * @author XieFan
 * @since 2017-08-11
 */
@TableName("mem_teacher_member_msg")
public class MemTeacherMemberMsg extends Model<MemTeacherMemberMsg> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 园校id
	 */
	@TableField("school_id")
	private String schoolId;
	/**
	 * 消息通知id
	 */
	@TableField("message_id")
	private String messageId;
	/**
	 * 父id
	 */
	@TableField("father_id")
	private String fatherId;
	/**
	 * 发送人id
	 */
	@TableField("send_id")
	private String sendId;
	/**
	 * 接收人id
	 */
	@TableField("sendee_id")
	private String sendeeId;
	/**
	 * 阅读标记
	 */
	@TableField("read_flag")
	private Integer readFlag;
	/**
	 * 阅读时间
	 */
	@TableField("read_time")
	private Date readTime;
	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private Date createTime;
	/**
	 * 修改人
	 */
	@TableField("update_man")
	private String updateMan;
	/**
	 * 修改时间
	 */
	@TableField("update_time")
	private Date updateTime;
	/**
	 * 删除标记
	 */
	@TableField("delete_flag")
	private Integer deleteFlag;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getSendeeId() {
		return sendeeId;
	}

	public void setSendeeId(String sendeeId) {
		this.sendeeId = sendeeId;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateMan() {
		return updateMan;
	}

	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
