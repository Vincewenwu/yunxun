package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 父母评语表
 * </p>
 *
 * @author XieFan
 * @since 2017-07-25
 */
@TableName("mem_parent_comments")
public class MemParentComments extends Model<MemParentComments> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 宝贝ID
     */
	@TableField("baby_id")
	private String babyId;
    /**
     * 宝贝学期ID
     */
	@TableField("baby_team_id")
	private String babyTeamId;
    /**
     * 在家天数
     */
	@TableField("day_home")
	private Integer dayHome;
    /**
     * 表现情况
     */
	private String behave;
    /**
     * 最棒方面
     */
	@TableField("best_way")
	private String bestWay;
    /**
     * 最大进步
     */
	@TableField("best_progress")
	private String bestProgress;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 创建人
     */
	@TableField("create_man")
	private String createMan;
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
     * 删除标记
     */
	@TableField("delete_flag")
	private Integer deleteFlag;


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

	public String getBabyTeamId() {
		return babyTeamId;
	}

	public void setBabyTeamId(String babyTeamId) {
		this.babyTeamId = babyTeamId;
	}

	public Integer getDayHome() {
		return dayHome;
	}

	public void setDayHome(Integer dayHome) {
		this.dayHome = dayHome;
	}

	public String getBehave() {
		return behave;
	}

	public void setBehave(String behave) {
		this.behave = behave;
	}

	public String getBestWay() {
		return bestWay;
	}

	public void setBestWay(String bestWay) {
		this.bestWay = bestWay;
	}

	public String getBestProgress() {
		return bestProgress;
	}

	public void setBestProgress(String bestProgress) {
		this.bestProgress = bestProgress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateMan() {
		return createMan;
	}

	public void setCreateMan(String createMan) {
		this.createMan = createMan;
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

}
