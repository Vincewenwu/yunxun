package com.vision.edu.dto;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 *  宝贝学校
 * @title 
 * @filename BaseBabySchool.java
 * @author ChenWenWu
 * @date 2017年7月6日 下午7:40:21
 * @version 1.0
 */
public class BaseBabySchoolDTO extends Model<BaseBabySchoolDTO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 班级ID
     */
	private String classId;
    /**
     * 性别
     */
	private Integer sex;
    /**
     * 姓名
     */
	private String name;
    /**
     * 生日
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date birthday;
    /**
     * 头像
     */
	private String headPortrait;
    /**
     * 年龄
     */
	private Integer age;
    /**
     * 学号
     */
	private String studentNum;
    /**
     * 入学时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date entranceTime;
    /**
     * 状态
     */
	private Integer state;
    /**
     * 到期时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date expirationDate;
    /**
     * 预警天数
     */
	private Integer warningDays;
    /**
     * 绑定账号最大数
     */
	private Integer bindingMaximum;
    /**
     * 当前绑定账号数
     */
	private Integer currentBindingCount;
    /**
     * 创建时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date createTime;
    /**
     * 创建人
     */
	private String createMam;
    /**
     * 修改时间
     */
	private Date updateTime;
    /**
     * 修改人
     */
	private String updateMan;
    /**
     * 0-未删除，1-已删除
     */
	private Integer deleteFlag;
	
/**
 * 班级id
 */
	private String classid;
	
	/**
	 * 班级名称
	 */
	private String class_name;
	
	/**
	 * 学校id
	 */
   private String schoolid;
	/**
	 * 学校名称
	 */
   private String  schoolname;
   /**
    * 分组ID
    */
   private String groupID;
   
   /**
    * 考情卡号
    */
   private String cardNums;
   /**
    * 卡号ID
    */
    private String cardID;
/**
 * 分组名称
 */
   private String groupName;
   /**
    * 与我关系
    */
   private String relationship;

	public String getCardID() {
	return cardID;
}

public void setCardID(String cardID) {
	this.cardID = cardID;
}

public String getGroupName() {
	return groupName;
}

public void setGroupName(String groupName) {
	this.groupName = groupName;
}

	public String getCardNums() {
	return cardNums;
}

public void setCardNums(String cardNums) {
	this.cardNums = cardNums;
}

	public String getGroupID() {
	return groupID;
}

public void setGroupID(String groupID) {
	this.groupID = groupID;
}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public Date getEntranceTime() {
		return entranceTime;
	}

	public void setEntranceTime(Date entranceTime) {
		this.entranceTime = entranceTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getWarningDays() {
		return warningDays;
	}

	public void setWarningDays(Integer warningDays) {
		this.warningDays = warningDays;
	}

	public Integer getBindingMaximum() {
		return bindingMaximum;
	}

	public void setBindingMaximum(Integer bindingMaximum) {
		this.bindingMaximum = bindingMaximum;
	}

	public Integer getCurrentBindingCount() {
		return currentBindingCount;
	}

	public void setCurrentBindingCount(Integer currentBindingCount) {
		this.currentBindingCount = currentBindingCount;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateMan() {
		return updateMan;
	}

	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(String schoolid) {
		this.schoolid = schoolid;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}


	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
