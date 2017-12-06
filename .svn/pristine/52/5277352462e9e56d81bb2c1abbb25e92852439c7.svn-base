package com.vision.edu.entity.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 园长信箱
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("sys_principal_mailbox")
public class SysPrincipalMailbox extends Model<SysPrincipalMailbox> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 父id
     */
	@TableField("father_id")
	private String fatherId;
    /**
     * 发送人ID
     */
	@TableField("sender_id")
	private String senderId;
    /**
     * 接收人ID
     */
	@TableField("recipient_id")
	private String recipientId;
    /**
     * 发送人类型【0-家长，1-院长】
     */
	@TableField("sender_type")
	private Integer senderType;
    /**
     * 信件内容
     */
	@TableField("letter_content")
	private String letterContent;
    /**
     * 附件（照片集）
     */
	private String images;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 查看时间
     */
	@TableField("see_time")
	private Date seeTime;
    /**
     * 状态【枚举：0-未读，1-已读，2-已回复】
     */
	private Integer state;
    /**
     * 0-未删除，1-已删除
     */
	@TableField("delete_flag")
	private Integer deleteFlag;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public Integer getSenderType() {
		return senderType;
	}

	public void setSenderType(Integer senderType) {
		this.senderType = senderType;
	}

	public String getLetterContent() {
		return letterContent;
	}

	public void setLetterContent(String letterContent) {
		this.letterContent = letterContent;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getSeeTime() {
		return seeTime;
	}

	public void setSeeTime(Date seeTime) {
		this.seeTime = seeTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
