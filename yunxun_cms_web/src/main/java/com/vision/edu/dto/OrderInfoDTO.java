package com.vision.edu.dto;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 订单DTO
 * @author jiangwangying
 * @date 2017年8月1日 下午10:09:12
 * @version 1.0
 */
public class OrderInfoDTO {

	/**
	 * 订单id
	 */
	private String id;
	
	/**
	 * 订单编号
	 */
	private String orderNum;
	
	
	/**
	 * 订单状态
	 */
	private Integer state;
	
	/**
	 * 套餐价格
	 */
	private Double comboPrice;
	
	/**
	 * 下单时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date orderTime;
	
	/**
	 * 支付类型
	 */
	private Integer paymentType;
	
	/**
	 * 支付时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date payTime;
	
	/**
	 * 订单类型
	 */
	private Integer orderType;
	
	/**
	 * 优惠金额
	 */
	private Double discountAmount;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 总价
	 */
	private Double totalAmount;
	
	/**
	 * 实付
	 */
	private Double payAmount;
	
	/**
	 * 取消时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date cancelTime;
	
	/**
	 * 取消类型
	 */
	private Integer cancelType;
	
	/**
	 * 删除标记
	 */
	private Integer deleteFlag;
	
	/**
	 * 套餐名称
	 */
	private String comboName;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 宝贝名称
	 */
	private String babyName;
	
	/**
	 * 用户名称
	 */
	private String memberName;
	
	/**
	 * 所属学校
	 */
	private String schoolName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
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
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getCancelType() {
		return cancelType;
	}
	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}
