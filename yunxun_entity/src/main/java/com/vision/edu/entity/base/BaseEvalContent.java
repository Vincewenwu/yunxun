package com.vision.edu.entity.base;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 评测内容
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_eval_content")
public class BaseEvalContent extends Model<BaseEvalContent> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 评测项目id
     */
	@TableField("eval_project_id")
	private String evalProjectId;
    /**
     * 内容名称
     */
	@TableField("content_name")
	private String contentName;
    /**
     * 标准名称
     */
	@TableField("standrad_name")
	private String standradName;
    /**
     * 得分范围
     */
	@TableField("scoring_range")
	private String scoringRange;
	/**
	 * 年级ID
	 */
	@TableField("grade_id")
	private String gradeId;
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
    /**
     *  学期  0-上学期，1-下学期
     */
	@TableField("team")
	private Integer team;
	

	//********************************扩展字段*********************************************
	/**
	 * 项目名称
	 */
	@TableField(exist=false)
	private String projectName;
	
	/**
	 * 年级名称
	 */
	@TableField(exist=false)
	private String gradeName;
	
	@TableField(exist=false)
	private String scoring;
	
	/**
	 * 字符串学期
	 */
	@TableField(exist=false)
	private String strteam;
	


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEvalProjectId() {
		return evalProjectId;
	}

	public void setEvalProjectId(String evalProjectId) {
		this.evalProjectId = evalProjectId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
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

	public String getStandradName() {
		return standradName;
	}

	public void setStandradName(String standradName) {
		this.standradName = standradName;
	}

	public String getScoringRange() {
		return scoringRange;
	}

	public void setScoringRange(String scoringRange) {
		this.scoringRange = scoringRange;
	}

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getScoring() {
		return scoring;
	}

	public void setScoring(String scoring) {
		this.scoring = scoring;
	}
	
	
	public Integer getTeam() {
		return team;
	}

	public void setTeam(Integer team) {
		this.team = team;
	}

	public String getStrteam() {
		return strteam;
	}

	public void setStrteam(String strteam) {
		this.strteam = strteam;
	}
	


}
