package com.vision.edu.entity.member;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 宝贝卡包
 * </p>
 *
 * @author XieFan
 * @since 2017-07-26
 */
@TableName("mem_baby_cards")
public class MemBabyCards extends Model<MemBabyCards> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 宝贝id
	 */
	@TableField("baby_id")
	private String babyId;
	/**
	 * 卡号
	 */
	@TableField("card_num")
	private String cardNum;
	/**
	 * 停用标记
	 */
	@TableField("blockup_flag")
	private Integer blockupFlag;
	/**
	 * 删除标记
	 */
	@TableField("delete_flag")
	private Integer deleteFlag;
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

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public Integer getBlockupFlag() {
		return blockupFlag;
	}

	public void setBlockupFlag(Integer blockupFlag) {
		this.blockupFlag = blockupFlag;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
