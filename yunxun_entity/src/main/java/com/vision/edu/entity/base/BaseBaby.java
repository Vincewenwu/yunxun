package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 宝贝
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_baby")
public class BaseBaby extends Model<BaseBaby> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 编号
	 */
	private String code;
	/**
	 * 园所ID
	 */
	@TableField("school_id")
	private String schoolId;
	/**
	 * 班级ID
	 */
	@TableField("class_id")
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
	private Date birthday;
	/**
	 * 头像
	 */
	@TableField("head_portrait")
	private String headPortrait;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 学号
	 */
	@TableField("student_num")
	private String studentNum;
	/**
	 * 入学时间
	 */
	@TableField("entrance_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date entranceTime;
	/**
	 * 状态
	 */
	private Integer state;
	/**
	 * 到期时间
	 */
	@TableField("expiration_date")
	private Date expirationDate;
	/**
	 * 预警天数
	 */
	@TableField("warning_days")
	private Integer warningDays;
	/**
	 * 当前绑定账号数
	 */
	@TableField("current_binding_count")
	private Integer currentBindingCount;
	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private Date createTime;
	/**
	 * 创建人
	 */
	@TableField("create_mam")
	private String createMam;
	/**
	 * 修改时间
	 */
	@TableField("update_time")
	private Date updateTime;
	/**
	 * 修改人
	 */
	@TableField("update_man")
	private String updateMan;
	/**
	 * 0-未删除，1-已删除
	 */
	@TableField("delete_flag")
	private Integer deleteFlag;

	/**
	 * 绑定码
	 */
	@TableField("binding_code")
	private String bindingCode;

	//*******************************扩展字段*****************************************
	/**
	 * 班级名称
	 */
	@TableField(exist=false)
	private String className;
	/**
	 * 年级ID
	 */
	@TableField(exist=false)
	private String gradeId;
	/**
	 * 年级名称
	 */
	@TableField(exist=false)
	private String gradeName;
	/**
	 * 园所名称
	 */
	@TableField(exist=false)
	private String schoolName;

	/**
	 * 开通业务家长手机号
	 */
	private String mobile;

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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getBindingCode() {
		return bindingCode;
	}

	public void setBindingCode(String bindingCode) {
		this.bindingCode = bindingCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
