package com.vision.edu.dto;

/**
 * @author ChenYuanRong
 * @date 2017年7月25日 上午8:54:59
 * @version 1.0
 */
public class SigStatisticsDTO 
{
	/**
	 * 宝贝id
	 */
	private String babyId;

    /**
     * 宝贝姓名
     */
	private String babyName;
	
	/**
	 * 班级名称
	 */
	private String className;
	
	/**
	 * 学校名称
	 */
	private String schoolName;
	
	/**
	 * 请假次数
	 */
	
	private Integer leaveRecordCount;
	
	/**
	 * 签到次数
	 */
	private Integer  signRecordCount;
	/**
	 * 请假时长
	 */
	private Integer leaveRecordLongTime;
	public String getBabyId() {
		return babyId;
	}
	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}
	public String getBabyName() {
		return babyName;
	}
	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Integer getLeaveRecordCount() {
		return leaveRecordCount;
	}
	public void setLeaveRecordCount(Integer leaveRecordCount) {
		this.leaveRecordCount = leaveRecordCount;
	}
	public Integer getSignRecordCount() {
		return signRecordCount;
	}
	public void setSignRecordCount(Integer signRecordCount) {
		this.signRecordCount = signRecordCount;
	}
	public Integer getLeaveRecordLongTime() {
		return leaveRecordLongTime;
	}
	public void setLeaveRecordLongTime(Integer leaveRecordLongTime) {
		this.leaveRecordLongTime = leaveRecordLongTime;
	}
	
}
