package com.vision.edu.entity.member;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 会员表记录的是纯家长信息
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_member")
public class MemMember extends Model<MemMember> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 用户基本信息ID
	 */
	@TableField("base_member_id")
	private String baseMemberId;
	/**
	 * 0-整除，1-停用
	 */
	@TableField("disable_flag")
	private Integer disableFlag;
	/**
	 * 宝贝ID（最后登陆宝贝ID）
	 */
	@TableField("baby_id")
	private String babyId;
	/**
	 * 最后登陆时间
	 */
	@TableField("last_landing_time")
	private Date lastLandingTime;
	/**
	 * 创建时间
	 */
	@TableField("create_time")
	private Date createTime;
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBaseMemberId() {
		return baseMemberId;
	}

	public void setBaseMemberId(String baseMemberId) {
		this.baseMemberId = baseMemberId;
	}

	public Integer getDisableFlag() {
		return disableFlag;
	}

	public void setDisableFlag(Integer disableFlag) {
		this.disableFlag = disableFlag;
	}

	public Date getLastLandingTime() {
		return lastLandingTime;
	}

	public void setLastLandingTime(Date lastLandingTime) {
		this.lastLandingTime = lastLandingTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getBabyId() {
		return babyId;
	}

	public void setBabyId(String babyId) {
		this.babyId = babyId;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
