package com.vision.edu.dto;
/**
 *查找提醒信息实体
 * @author ChenWenWu
 * @date 2017年8月1日 下午9:42:21
 * @version 1.0
 */
public class MemMessageDTO {
	/**
	 * 学院ID
	 */
    private String schoolId;
    
    /**
	 * 学院名称
	 */
    private String shoolName;
    /**
	 * 提醒内容
	 */
    private String content;
    /**
	 * 提醒人
	 */
    private String baseName;
    /**
	 * 被提醒人
	 */
    private String memberName;
    /**
	 * 提醒类型
	 */
    private String messageType;
    /**
	 * 详情链接
	 */
    private String url;
    /**
	 * 创建时间
	 */
    private String createTime;
    /**
	 * 创建人
	 */
    private String createMam;
    /**
     * 删除标记
     */
    private String deleteFlag;
    /**
     * 确认标记
     */
    private String confirmFlag;
    
    /**
     * 提醒消息ID
     */
    private String id;

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
	public String getShoolName() {
		return shoolName;
	}
	public void setShoolName(String shoolName) {
		this.shoolName = shoolName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateMam() {
		return createMam;
	}
	public void setCreateMam(String createMam) {
		this.createMam = createMam;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getConfirmFlag() {
		return confirmFlag;
	}
	public void setConfirmFlag(String confirmFlag) {
		this.confirmFlag = confirmFlag;
	}
}
