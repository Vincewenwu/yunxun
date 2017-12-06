package com.vision.edu.entity.base;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 职务表
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_duties")
public class BaseDuties extends Model<BaseDuties> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 园校id
     */
	@TableField("school_id")
	private String schoolId;
    /**
     * 职务名称
     */
	@TableField("duties_name")
	private String dutiesName;
    /**
     * 职务描述
     */
	private String description;
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
     * 0-未删除，1-已删除
     */
	@TableField("delete_flag2")
	private Integer deleteFlag2;
    /**
     * 修改人
     */
	@TableField("update_man")
	private String updateMan;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getDutiesName() {
		return dutiesName;
	}

	public void setDutiesName(String dutiesName) {
		this.dutiesName = dutiesName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getDeleteFlag2() {
		return deleteFlag2;
	}

	public void setDeleteFlag2(Integer deleteFlag2) {
		this.deleteFlag2 = deleteFlag2;
	}

	public String getUpdateMan() {
		return updateMan;
	}

	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
