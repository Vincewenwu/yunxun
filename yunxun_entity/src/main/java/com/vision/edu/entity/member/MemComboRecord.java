package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 套餐购买记录
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_combo_record")
public class MemComboRecord extends Model<MemComboRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 订单id
     */
	@TableField("order_id")
	private String orderId;
    /**
     * 用户ID
     */
	@TableField("user_id")
	private String userId;
    /**
     * 套餐ID
     */
	@TableField("combo_id")
	private String comboId;
    /**
     * 价格
     */
	private Double price;
    /**
     * 购买时间
     */
	@TableField("pay_time")
	private Date payTime;
    /**
     * 创建时间
     */
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
     * 到期时间
     */
	@TableField("expire_time")
	private Date expireTime;
    /**
     * 套餐状态[枚举]
     */
	private Integer status;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
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

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
