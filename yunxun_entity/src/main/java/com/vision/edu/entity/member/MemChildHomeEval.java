package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 家长给孩子的在家表现评价
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_child_home_eval")
public class MemChildHomeEval extends Model<MemChildHomeEval> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 院校id
     */
	@TableField("school_id")
	private String schoolId;
    /**
     * 宝贝id
     */
	@TableField("baby_id")
	private String babyId;
    /**
     * 评价标准id
     */
	@TableField("eval_criter_id")
	private String evalCriterId;
    /**
     * 周次[1-12周]
     */
	private Integer weekly;
    /**
     * 得星数
     */
	@TableField("star_num")
	private Integer starNum;
	/**
	 * 学期
	 */
	@TableField("baby_team_id")
	private String tream;
    /**
     * 创建人
     */
	@TableField("create_mam")
	private String createMam;
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
	 * 宝贝学期id
	 */
	@TableField("baby_team_id")
	private String babyTeamId;


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

	public String getBabyId() {
		return babyId;
	}

	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}

	public String getEvalCriterId() {
		return evalCriterId;
	}

	public void setEvalCriterId(String evalCriterId) {
		this.evalCriterId = evalCriterId;
	}

	public Integer getWeekly() {
		return weekly;
	}

	public void setWeekly(Integer weekly) {
		this.weekly = weekly;
	}

	public Integer getStarNum() {
		return starNum;
	}

	public void setStarNum(Integer starNum) {
		this.starNum = starNum;
	}

	public String getCreateMam() {
		return createMam;
	}

	public void setCreateMam(String createMam) {
		this.createMam = createMam;
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



	public String getTream() {
		return tream;
	}

	public void setTream(String tream) {
		this.tream = tream;
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
	

}
