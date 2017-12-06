package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 动态表包含[成长轨迹，营养食谱，班级圈，课堂动态，考勤签到....]
 * </p>
 *
 * @author XieFan
 * @since 2017-07-17
 */
@TableName("mem_dynamic")
public class MemDynamic extends Model<MemDynamic> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 资源ID
     */
	@TableField("resources_id")
	private String resourcesId;
    /**
     * 资源类型[枚举：]
     */
	@TableField("resources_type")
	private Integer resourcesType;
    /**
     * 园校ID
     */
	@TableField("school_id")
	private String schoolId;
    /**
     * 班级ID
     */
	@TableField("class_id")
	private String classId;
    /**
     * 浏览数
     */
	@TableField("browse_count")
	private Integer browseCount;
    /**
     * 点赞数
     */
	@TableField("point_count")
	private Integer pointCount;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 创建人
     */
	@TableField("create_mam_id")
	private String createMamId;
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
     * 删除标记
     */
	@TableField("delete_flag")
	private Integer deleteFlag;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}

	public Integer getResourcesType() {
		return resourcesType;
	}

	public void setResourcesType(Integer resourcesType) {
		this.resourcesType = resourcesType;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public Integer getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}

	public Integer getPointCount() {
		return pointCount;
	}

	public void setPointCount(Integer pointCount) {
		this.pointCount = pointCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateMamId() {
		return createMamId;
	}

	public void setCreateMamId(String createMamId) {
		this.createMamId = createMamId;
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
		return this.id;
	}

}
