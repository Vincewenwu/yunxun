package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 签到记录
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_sign_record")
public class BaseSignRecord extends Model<BaseSignRecord> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 宝贝基本信息ID
	 */
	@TableField("baby_id")
	private String babyId;
	/**
	 * 打卡人头像
	 */
	@TableField("punch_man_img")
	private String punchManImg;
	/**
	 * 签到卡号
	 */
	@TableField("sign_num")
	private String signNum;
	/**
	 * 设备号
	 */
	@TableField("device_num")
	private String deviceNum;
    /**
	 * 签到记录类型[枚举：1-入校，2-出校，3-上车，4-下车]
	 */
	@TableField("record_type")
	private Integer recordType;
	/**
	 * 签到状态
	 */
	@TableField("sign_status")
	private Integer signStatus;
	/**
	 * 接送人ID
	 */
	@TableField("surrogate_id")
	private String surrogateId;
	/**
	 * 签到时间
	 */
	@TableField("sign_time")
	private Date signTime;
	/**
	 * 体温
	 */
	private String temperature;
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
	 * 时间段
	 */
	@TableField("time_frame")
	private Integer timeFrame;


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

	public String getPunchManImg() {
		return punchManImg;
	}

	public void setPunchManImg(String punchManImg) {
		this.punchManImg = punchManImg;
	}

	public String getSignNum() {
		return signNum;
	}

	public void setSignNum(String signNum) {
		this.signNum = signNum;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public Integer getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(Integer signStatus) {
		this.signStatus = signStatus;
	}

	public String getSurrogateId() {
		return surrogateId;
	}

	public void setSurrogateId(String surrogateId) {
		this.surrogateId = surrogateId;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
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

	public Integer getTimeFrame() {
		return timeFrame;
	}

	public void setTimeFrame(Integer timeFrame) {
		this.timeFrame = timeFrame;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
