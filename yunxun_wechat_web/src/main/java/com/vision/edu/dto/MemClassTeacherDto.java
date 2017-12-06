package com.vision.edu.dto;

import java.util.Date;

/**
 * 
 * @author lichenglong
 * @date 2017年7月25日 下午12:12:49
 * @version 1.0
 */
public class MemClassTeacherDto {
	private String classId;//班级ID
	private String className;//班级名称
	private String peopleNum;//总人数
	private String schoolId;//园校id
	private String teacherId;//班主任ID
	private String gradeId;//
	private String description;//班级描述
	private Date createTime;//创建时间
	private String createMam;//创建人
	private String memberId;//老师id
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateMam() {
		return createMam;
	}
	public void setCreateMam(String createMam) {
		this.createMam = createMam;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	@Override
	public String toString() {
		return "MemClassTeacherDto [classId=" + classId + ", className=" + className + ", peopleNum=" + peopleNum
				+ ", schoolId=" + schoolId + ", teacherId=" + teacherId + ", gradeId=" + gradeId + ", description="
				+ description + ", createTime=" + createTime + ", createMam=" + createMam + ", memberId=" + memberId
				+ "]";
	}
}
