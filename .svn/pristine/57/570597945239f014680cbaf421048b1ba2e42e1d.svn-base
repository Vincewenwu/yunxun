package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 宝贝评测
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_baby_eval")
public class MemBabyEval extends Model<MemBabyEval> {

    private static final long serialVersionUID = 1L;

    /**
     * 宝贝评测ID
     */
	private String id;
    /**
     * 宝贝id
     */
	@TableField("baby_id")
	private String babyId;
    /**
     * 评测项目id
     */
	@TableField("eval_item_id")
	private String evalItemId;
	
	@TableField(exist=false)
	private String gradeName;
    /**
     * 评测内容id
     */
	@TableField("eval_content_id")
	private String evalContentId;
    /**
     * 得分
     */
	private Integer score;
	/**
	 * 宝贝学期ID
	 */
	@TableField("baby_team_id")
	private String babyTeamId;
    /**
     * 创建人
     */
	@TableField("create_man")
	private String createMan;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 修改人
     */
	@TableField("update_man")
	private String updateMan;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 删除标记
     */
	@TableField("delete_flag")
	private Integer deleteFlag;
	
	//********************************************扩展字段****************************************************
	/**
	 * 项目名称
	 */
	@TableField(exist=false)
	private String projectName;
	/**
	 * 项目内容
	 */
	@TableField(exist=false)
	private String contentName;
	/**
	 * 评价标准
	 */
	@TableField(exist=false)
	private String standradName;
	/**
	 * 班级
	 */
	@TableField(exist=false)
	private String className;
	/**
	 * 宝贝
	 */
	@TableField(exist=false)
	private String babyName;
	/**
	 * 学校名称
	 */
	@TableField(exist=false)
	private String schoolName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBabyId() {
		return babyId;
	}

	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}

	public String getEvalItemId() {
		return evalItemId;
	}

	public void setEvalItemId(String evalItemId) {
		this.evalItemId = evalItemId;
	}

	public String getEvalContentId() {
		return evalContentId;
	}

	public void setEvalContentId(String evalContentId) {
		this.evalContentId = evalContentId;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateMan() {
		return updateMan;
	}

	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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

	public String getBabyTeamId() {
		return babyTeamId;
	}

	public void setBabyTeamId(String babyTeamId) {
		this.babyTeamId = babyTeamId;
	}

	/**
	 * @return the gradeName
	 */
	public String getGradeName() {
		return gradeName;
	}

	/**
	 * @param gradeName the gradeName to set
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getStandradName() {
		return standradName;
	}

	public void setStandradName(String standradName) {
		this.standradName = standradName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBabyName() {
		return babyName;
	}

	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	

}
