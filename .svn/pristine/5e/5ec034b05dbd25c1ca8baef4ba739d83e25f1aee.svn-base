package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 宝贝接送人
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_baby_surrogate")
public class MemBabySurrogate extends Model<MemBabySurrogate> {

    private static final long serialVersionUID = 1L;

    /**
     * 接送人id
     */
	@TableField("surrogate_id")
	private String surrogateId;
    /**
     * 家长宝贝id
     */
	@TableField("parent_baby_id")
	private String parentBabyId;
    /**
     * 与我关系类型
     */
	private Integer relationship;
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


	public String getSurrogateId() {
		return surrogateId;
	}

	public void setSurrogateId(String surrogateId) {
		this.surrogateId = surrogateId;
	}

	public String getParentBabyId() {
		return parentBabyId;
	}

	public void setParentBabyId(String parentBabyId) {
		this.parentBabyId = parentBabyId;
	}

	public Integer getRelationship() {
		return relationship;
	}

	public void setRelationship(Integer relationship) {
		this.relationship = relationship;
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

	@Override
	protected Serializable pkVal() {
		return null;
	}

}
