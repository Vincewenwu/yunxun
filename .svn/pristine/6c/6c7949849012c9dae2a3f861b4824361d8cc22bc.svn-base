package com.vision.edu.entity.base;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 预报名记录
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_sorecast_record")
public class BaseSorecastRecord extends Model<BaseSorecastRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 用户基本信息id
     */
	@TableField("base_user_id")
	private String baseUserId;
    /**
     * 报名状态
     */
	@TableField("enter_status")
	private Integer enterStatus;
    /**
     * 报名时间
     */
	@TableField("enter_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date enterTime;
    /**
     * 修改人
     */
	@TableField("update_man")
	private String updateMan;
    /**
     * 修改时间
     */
	@TableField("update_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
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

	public String getBaseUserId() {
		return baseUserId;
	}

	public void setBaseUserId(String baseUserId) {
		this.baseUserId = baseUserId;
	}

	public Integer getEnterStatus() {
		return enterStatus;
	}

	public void setEnterStatus(Integer enterStatus) {
		this.enterStatus = enterStatus;
	}

	public Date getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
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

}
