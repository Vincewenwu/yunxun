package com.vision.edu.entity.base;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.sql.Time;

/**
 * <p>
 * 园校，记录的是园校的基本信息
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_school")
public class BaseSchool extends Model<BaseSchool> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 父ID
     */
	@TableField("father_id")
	private String fatherId;
    /**
     * 学校名称
     */
	private String name;
	/**
     * 学校编号
     */
	private String code;
    /**
     * 地址
     */
	private String address;
    /**
     * 联系电话
     */
	private String telephone;
    /**
     * 坐标
     */
	private String coordinate;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 学校logo
     */
	private String logo;
    /**
     * 省id
     */
	@TableField("province_id")
	private Integer provinceId;
    /**
     * 市id
     */
	@TableField("city_id")
	private Integer cityId;
    /**
     * 县/区id
     */
	@TableField("county_id")
	private Integer countyId;
    /**
     * 服务状态：0-正常，1-已过期，2-未开通
     */
	private Integer state;
    /**
     * 有效时间
     */
	@TableField("effective_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date effectiveTime;
    /**
     * 预警天数
     */
	@TableField("warning_days")
	private Integer warningDays;
    /**
     * 学校简介
     */
	private String intro;
    /**
     * 网址
     */
	private String website;
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
     * 上午签到截止时间
     */
	@TableField("am_check_in_deadline")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Time amCheckInDeadline;
    /**
     * 下午签到截止时间
     */
	@TableField("pm_check_in_deadline")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Time pmCheckInDeadline;
    /**
     * 上午签离开始时间
     */
	@TableField("am_check_out_deadline")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Time amCheckOutDeadline;
    /**
     * 下午签离开始时间
     */
	@TableField("pm_check_out_deadline")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Time pmCheckOutDeadline;
    /**
     * 食谱发布时间[设置食谱统一发布时间]
     */
	@TableField("recipe_publish_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Time recipePublishTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public Integer getWarningDays() {
		return warningDays;
	}

	public void setWarningDays(Integer warningDays) {
		this.warningDays = warningDays;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public Time getAmCheckInDeadline() {
		return amCheckInDeadline;
	}

	public void setAmCheckInDeadline(Time amCheckInDeadline) {
		this.amCheckInDeadline = amCheckInDeadline;
	}

	public Date getPmCheckInDeadline() {
		return pmCheckInDeadline;
	}

	public void setPmCheckInDeadline(Time pmCheckInDeadline) {
		this.pmCheckInDeadline = pmCheckInDeadline;
	}

	public Time getAmCheckOutDeadline() {
		return amCheckOutDeadline;
	}

	public void setAmCheckOutDeadline(Time amCheckOutDeadline) {
		this.amCheckOutDeadline = amCheckOutDeadline;
	}

	public Time getPmCheckOutDeadline() {
		return pmCheckOutDeadline;
	}

	public void setPmCheckOutDeadline(Time pmCheckOutDeadline) {
		this.pmCheckOutDeadline = pmCheckOutDeadline;
	}

	public Time getRecipePublishTime() {
		return recipePublishTime;
	}

	public void setRecipePublishTime(Time recipePublishTime) {
		this.recipePublishTime = recipePublishTime;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
