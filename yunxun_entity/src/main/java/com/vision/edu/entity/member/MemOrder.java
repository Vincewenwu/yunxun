package com.vision.edu.entity.member;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_order")
public class MemOrder extends Model<MemOrder> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 订单状态[枚举：0-未支付，]
	 */
	private Integer state;
	/**
	 * 下单时间
	 */
	@TableField("order_time")
	private Date orderTime;
	/**
	 * 支付时间
	 */
	@TableField("pay_time")
	private Date payTime;
	/**
	 * 支付方式
	 */
	@TableField("payment_type")
	private Integer paymentType;
	/**
	 * 订单类型[枚举：0-平台服务，1-在线资源]
	 */
	@TableField("order_type")
	private Integer orderType;
	/**
	 * 平台服务套餐id
	 */
	@TableField("combo_id")
	private String comboId;
	/**
	 * 订单编号
	 */
	@TableField("order_num")
	private String orderNum;
	/**
	 * 应付金额
	 */
	@TableField("total_amount")
	private Double totalAmount;
	/**
	 * 优惠金额
	 */
	@TableField("discount_amount")
	private Double discountAmount;
	/**
	 * 实付金额
	 */
	@TableField("pay_amount")
	private Double payAmount;
	/**
	 * 取消时间
	 */
	@TableField("cancel_time")
	private Date cancelTime;
	/**
	 * 取消类型
	 */
	@TableField("cancel_type")
	private Integer cancelType;
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
	 * 家长id
	 */
	@TableField("member_id")
	private String memberId;

	/**
	 * 宝贝id
	 */
	@TableField("baby_id")
	private String babyId;

	/**
	 * 套餐天数
	 */
	@TableField("when_long")
	private Integer whenLong;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Integer getCancelType() {
		return cancelType;
	}

	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBabyId() {
		return babyId;
	}

	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}

	public Integer getWhenLong() {
		return whenLong;
	}

	public void setWhenLong(Integer whenLong) {
		this.whenLong = whenLong;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
