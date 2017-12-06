package com.vision.edu.dto;
/**
 * 查询班级圈的dto
 * @author ChenWenWu
 * @date 2017年7月24日 下午3:05:28
 * @version 1.0
 */
public class MemClassCircleDTO {
	/**
	 * 前台用户头像
	 */
    private String memMemberHeadPortrait;
    /**
	 * 后台用户头像
	 */
    private String sysUserHeadPortrait;
    /**
	 * 校园圈ID
	 */
    private String id;
    /**
	 * 标签ID
	 */
    private String lableID;
    /**
	 * 图片集
	 */
    private String imgs;
    /**
	 * 内容
	 */
    private String content;
    /**
	 * 评论数
	 */
    private String commentNum;
    /**
	 * 点赞数
	 */
    private String pointCount;
    /**
	 * 浏览数
	 */
    private String browseCount;
    /**
	 * 创建时间
	 */
    private String createTime;
    /**
	 * 删除标记
	 */
    private boolean deleteFlag;
    /**
	 * 前台用户名称
	 */
    private String baseName;
    /**
	 * 后台用户名称
	 */
    private String memName;
    /**
	 * 学院名称
	 */
    private String shoolName;
    /**
	 * 班级名称
	 */
    private String className;
    /**
     * 学院ID
     */
    private String schoolID;
    /**
     * 便签名称
     */
    private String lableName;
	public String getLableName() {
		return lableName;
	}
	public void setLableName(String lableName) {
		this.lableName = lableName;
	}
	public String getMemMemberHeadPortrait() {
		return memMemberHeadPortrait;
	}
	public void setMemMemberHeadPortrait(String memMemberHeadPortrait) {
		this.memMemberHeadPortrait = memMemberHeadPortrait;
	}
	public String getSysUserHeadPortrait() {
		return sysUserHeadPortrait;
	}
	public void setSysUserHeadPortrait(String sysUserHeadPortrait) {
		this.sysUserHeadPortrait = sysUserHeadPortrait;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLableID() {
		return lableID;
	}
	public void setLableID(String lableID) {
		this.lableID = lableID;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}
	public String getPointCount() {
		return pointCount;
	}
	public void setPointCount(String pointCount) {
		this.pointCount = pointCount;
	}
	public String getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(String browseCount) {
		this.browseCount = browseCount;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getBaseName() {
		return baseName;
	}
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getShoolName() {
		return shoolName;
	}
	public void setShoolName(String shoolName) {
		this.shoolName = shoolName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(String schoolID) {
		this.schoolID = schoolID;
	}
    
}
