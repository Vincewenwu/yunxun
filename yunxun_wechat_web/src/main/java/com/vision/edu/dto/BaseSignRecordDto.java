package com.vision.edu.dto;

import java.util.Date;

/**
 * 考勤签到
 * @author lichenglong
 * @date 2017年7月16日 下午4:03:33
 * @version 1.0
 */
public class BaseSignRecordDto {
	
	private String headPortrait;//头像
	private String babyName;//姓名
	private Integer recordType;//签到记录类型
	private String temperature;//体温
	private String signRecordId;//签到记录主键
	private String babyId;//宝贝ID
	private String punchManImg;//打卡人头像
	private String signNum;//签到卡号
	private Integer signStatus;//签到状态
	private String surrogateId;//接送人ID
	private Date signTime;//签到时间
	private Integer timeFrame;//时间段
	private String className;//班级名称
	private String classId;//班级ID
	private String schoolId;//园校id
	private Integer peopleNum;//总人数
	
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getBabyName() {
		return babyName;
	}
	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}
	public Integer getRecordType() {
		return recordType;
	}
	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getSignRecordId() {
		return signRecordId;
	}
	public void setSignRecordId(String signRecordId) {
		this.signRecordId = signRecordId;
	}
	public String getBabyId() {
		return babyId;
	}
	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}
	public String getPunchManImg() {
		return punchManImg;
	}
	public void setPunchManImg(String punchManImg) {
		this.punchManImg = punchManImg;
	}
	public String getSignNum() {
		return signNum;
	}
	public void setSignNum(String signNum) {
		this.signNum = signNum;
	}
	public Integer getSignStatus() {
		return signStatus;
	}
	public void setSignStatus(Integer signStatus) {
		this.signStatus = signStatus;
	}
	public String getSurrogateId() {
		return surrogateId;
	}
	public void setSurrogateId(String surrogateId) {
		this.surrogateId = surrogateId;
	}
	public Date getSignTime() {
		return signTime;
	}
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public Integer getTimeFrame() {
		return timeFrame;
	}
	public void setTimeFrame(Integer timeFrame) {
		this.timeFrame = timeFrame;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public Integer getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
	}
	
	@Override
	public String toString() {
		return "BaseSignRecordDto [headPortrait=" + headPortrait + ", babyName=" + babyName + ", recordType="
				+ recordType + ", temperature=" + temperature + ", signRecordId=" + signRecordId + ", babyId=" + babyId
				+ ", punchManImg=" + punchManImg + ", signNum=" + signNum + ", signStatus=" + signStatus
				+ ", surrogateId=" + surrogateId + ", signTime=" + signTime + ", timeFrame=" + timeFrame
				+ ", className=" + className + ", classId=" + classId + ", schoolId=" + schoolId + ", peopleNum="
				+ peopleNum + "]";
	}
	
}
