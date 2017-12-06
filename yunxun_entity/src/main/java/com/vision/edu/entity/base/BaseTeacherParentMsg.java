package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 老师家长消息基础表
 * </p>
 *
 * @author XieFan
 * @since 2017-08-11
 */
@TableName("base_teacher_parent_msg")
public class BaseTeacherParentMsg extends Model<BaseTeacherParentMsg> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 消息标题
	 */
	@TableField("message_title")
	private String messageTitle;
	/**
	 * 消息内容
	 */
	@TableField("message_content")
	private String messageContent;
	/**
	 * 图片集
	 */
	private String images;
	/**
	 * 语音
	 */
	private String voice;
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
	/**
	 * 微信推送标记
	 */
	@TableField("wechat_flag")
	private Integer wechatFlag;
	/**
	 * 详情url
	 */
	private String url;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
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

	public Integer getWechatFlag() {
		return wechatFlag;
	}

	public void setWechatFlag(Integer wechatFlag) {
		this.wechatFlag = wechatFlag;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
