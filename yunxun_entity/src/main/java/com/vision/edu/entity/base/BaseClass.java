package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 班级
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_class")
public class BaseClass extends Model<BaseClass> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 园校id
	 */
	@TableField("school_id")
	private String schoolId;
	/**
	 * 班主任ID
	 */
	@TableField("teacher_id")
	private String teacherId;

	/**
	 * 年级id
	 */
	@TableField("grade_id")
	private String gradeId;
	/**
	 * 班级名称
	 */
	@TableField("class_name")
	private String className;
	/**
	 * 总人数
	 */
	@TableField("people_num")
	private Integer peopleNum;
	/**
	 * 班级描述
	 */
	private String description;
	/**
	 * 创建时间
	 */
	@TableField("create_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(Integer peopleNum) {
		this.peopleNum = peopleNum;
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

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
