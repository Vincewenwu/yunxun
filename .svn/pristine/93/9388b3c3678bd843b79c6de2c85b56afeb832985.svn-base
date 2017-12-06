package com.vision.edu.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班级圈
 * @author lichenglong
 * @date 2017年7月17日 上午9:38:40
 * @version 1.0
 */
public class MemClassCircleDto {
	private String memMemberHeadPortrait;//家长头像
	private String memMemberName;//家长名称
	private String sysUserHeadPortrait;//老师头像
	private String sysUserName;//老师名称
	private String circleDutiesName;//职务名称
	private String schoolId;//园校ID
	private String classId;//班级ID
	private String lableId;//标签id
	private String imgs;//图片集
	private List<ResourceCollectionDto> listResourceCollectionDto;//图片集合
	private String content;//内容
	private Integer commentNum;//评论数
	private Integer pointCount;//点赞数
	private Integer browseCount;//浏览数
	private Date createTime;//创建时间
	private String createMamId;//创建人id
	private String resourcesId;//资源id
	private List<Map<String, String>> imgList;
	
	public String getMemMemberHeadPortrait() {
		return memMemberHeadPortrait;
	}
	public void setMemMemberHeadPortrait(String memMemberHeadPortrait) {
		this.memMemberHeadPortrait = memMemberHeadPortrait;
	}
	public String getMemMemberName() {
		return memMemberName;
	}
	public void setMemMemberName(String memMemberName) {
		this.memMemberName = memMemberName;
	}
	public String getSysUserHeadPortrait() {
		return sysUserHeadPortrait;
	}
	public void setSysUserHeadPortrait(String sysUserHeadPortrait) {
		this.sysUserHeadPortrait = sysUserHeadPortrait;
	}
	public String getSysUserName() {
		return sysUserName;
	}
	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}
	public String getCircleDutiesName() {
		return circleDutiesName;
	}
	public void setCircleDutiesName(String circleDutiesName) {
		this.circleDutiesName = circleDutiesName;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getLableId() {
		return lableId;
	}
	public void setLableId(String lableId) {
		this.lableId = lableId;
	}
	public String getImgs() {
		return imgs;
	}
	public void setImgs(String imgs) {
		this.imgs = imgs;
	}
	public List<ResourceCollectionDto> getListResourceCollectionDto() {
		return listResourceCollectionDto;
	}
	public void setListResourceCollectionDto(List<ResourceCollectionDto> listResourceCollectionDto) {
		this.listResourceCollectionDto = listResourceCollectionDto;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public Integer getPointCount() {
		return pointCount;
	}
	public void setPointCount(Integer pointCount) {
		this.pointCount = pointCount;
	}
	public Integer getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateMamId() {
		return createMamId;
	}
	public void setCreateMamId(String createMamId) {
		this.createMamId = createMamId;
	}
	public String getResourcesId() {
		return resourcesId;
	}
	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}
	
	@Override
	public String toString() {
		return "MemClassCircleDto [memMemberHeadPortrait=" + memMemberHeadPortrait + ", memMemberName=" + memMemberName
				+ ", sysUserHeadPortrait=" + sysUserHeadPortrait + ", sysUserName=" + sysUserName
				+ ", circleDutiesName=" + circleDutiesName + ", schoolId=" + schoolId + ", classId=" + classId
				+ ", lableId=" + lableId + ", imgs=" + imgs + ", listResourceCollectionDto=" + listResourceCollectionDto
				+ ", content=" + content + ", commentNum=" + commentNum + ", pointCount=" + pointCount
				+ ", browseCount=" + browseCount + ", createTime=" + createTime + ", createMamId=" + createMamId
				+ ", resourcesId=" + resourcesId + "]";
	}
	public List<Map<String, String>> getImgList() {
		return imgList;
	}
	public void setImgList(List<Map<String, String>> imgList) {
		imgList = new ArrayList<>();
		String[] images = this.imgs.split(",");
		for(String img:images){
			Map<String, String> src = new HashMap<>();
			src.put("src", img);
			imgList.add(src);
		}
		this.imgList = imgList;
	}
}
