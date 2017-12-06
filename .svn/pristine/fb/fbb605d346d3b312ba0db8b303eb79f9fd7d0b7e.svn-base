package com.vision.edu.entity.base;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 宝贝在家评价
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_eval_crite")
public class BaseEvalCrite extends Model<BaseEvalCrite> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 项目名称
     */
	@TableField("project_name")
	private String projectName;
    /**
     * 评价标准
     */
	@TableField("eval_crite")
	private String evalCrite;
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
	
	
	
	
	//*********************************************扩展字段*******************************************************
	/**
	 * 年级名称
	 */
	@TableField(exist=false)
	private String gradeName;
	/**
	 * 字符串类型学期
	 */
	@TableField(exist=false)
	private String strteam;


	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEvalCrite() {
		return evalCrite;
	}

	public void setEvalCrite(String evalCrite) {
		this.evalCrite = evalCrite;
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

	public String getGradeId() {
		return gradeId;
	}

	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
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
