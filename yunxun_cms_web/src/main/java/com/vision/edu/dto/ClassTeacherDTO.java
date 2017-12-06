package com.vision.edu.dto;

import org.apache.commons.lang3.StringUtils;

/**
 * 班级教师DTO
 * @author jiangwangying
 * @date 2017年8月1日 上午8:42:07
 * @version 1.0
 */
public class ClassTeacherDTO {

	/**
	 * 教师id
	 */
    private String id;
    
    /**
	 * 班级教师id
	 */
    private String memClassTeacherId;
    
    /**
	 * 园校id
	 */
    private String schoolId;
    /**
	 * 头像
	 */
    private String headPortrait;
    /**
	 * 简介
	 */
    private String intro;
    /**
	 * 姓名
	 */
    private String name;
    /**
	 * 班级名称
	 */
    private String className;
    
    /**
     * 年级
     */
    private String gradeName;
    /**
	 * 职务名称
	 */
    private String dutiesName;
    /**
	 * 所属学校
	 */
    private String schoolName;
    
    /**
     * 删除标记
     */
    private Integer deleteFlag;
  
    /**
     * 签名
     */
    private String signature;
    
    /**
     * 地址
     */
    private String address;
    
    /**
     * 性别
     */
    private Integer sex;
    
    /**
     * 电话号码
     */
    private String phoneNum;
    
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getIntro() {
		if (StringUtils.isEmpty(intro)) {
			intro = "未填写";
		}
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		if (StringUtils.isEmpty(className)) {
			className = "未分班";
		}
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getSignature() {
		if (StringUtils.isEmpty(signature)) {
			signature = "未填写";
		}
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhoneNum() {
		if (StringUtils.isEmpty(phoneNum)) {
			phoneNum = "未知";
		}
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getDutiesName() {
		return dutiesName;
	}
	public void setDutiesName(String dutiesName) {
		if (StringUtils.isEmpty(dutiesName)) {
			dutiesName = "未知";
		}
		this.dutiesName = dutiesName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getGradeName() {
		if (StringUtils.isEmpty(gradeName)) {
			gradeName = "分班显示" ;
		}
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getMemClassTeacherId() {
		return memClassTeacherId;
	}
	public void setMemClassTeacherId(String memClassTeacherId) {
		this.memClassTeacherId = memClassTeacherId;
	}
    
}
