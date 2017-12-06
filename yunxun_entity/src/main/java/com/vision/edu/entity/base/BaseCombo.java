package com.vision.edu.entity.base;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 套餐
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_combo")
public class BaseCombo extends Model<BaseCombo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 套餐名称
     */
	private String name;
    /**
     * 套餐价格
     */
	private Double price;
	 /**
     * 开始时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	@TableField("start_time")
	private Date startTime;
	
	 /**
     * 结束时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	@TableField("end_time")
	private Date endTime;
    /**
     * 时长
     */
	@TableField("when_long")
	private Integer whenLong;
    /**
     * 折扣
     */
	private Integer discount;
    /**
     * 创建时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	@TableField("create_time")
	private Date createTime;
    /**
     * 创建人
     */
	@TableField("create_mam")
	private String createMam;
    /**
     * 修改时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
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
     * 学院ID
     */
	@TableField("shool_id")
	private String shoolID;
   
	public String getShoolID() {
		return shoolID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getWhenLong() {
		return whenLong;
	}

	public void setWhenLong(Integer whenLong) {
		this.whenLong = whenLong;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public void setShoolID(String shoolID) {
		this.shoolID = shoolID;
	}
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
