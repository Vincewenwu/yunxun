package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 签到表，宝贝排班的时候就要添加到签到表，每天定时更新这表的状态。签到，签离时候更新这签到状态，同时同步新增一条签到记录到
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_sign")
public class BaseSign extends Model<BaseSign> {

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
	 * 签到记录类型[枚举：1-入校，2-出校,3-上车,4-下车]
	 */
	@TableField("record_type")
	private Integer recordType;
	/**
	 * 签到状态
	 */
	@TableField("sing_state")
	private Integer singState;
	/**
	 * 签到时间
	 */
	@TableField("sign_time")
	private Date signTime;
	/**
	 * 语音url
	 */
	@TableField("voice_url")
	private String voiceUrl;
	/**
	 * 体温
	 */
	private String temperature;
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

	public Integer getRecordType() {
		return recordType;
	}

	public void setRecordType(Integer recordType) {
		this.recordType = recordType;
	}

	public Integer getSingState() {
		return singState;
	}

	public void setSingState(Integer singState) {
		this.singState = singState;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getVoiceUrl() {
		return voiceUrl;
	}

	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
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
