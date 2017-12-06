package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 成长轨迹
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_growth")
public class MemGrowth extends Model<MemGrowth> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 发布人id
     */
	@TableField("publisher_id")
	private String publisherId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 摘要
     */
	private String summary;
    /**
     * 资源集
     */
	@TableField("resource_set")
	private String resourceSet;
    /**
     * 动态内容
     */
	@TableField("dynamic_content")
	private String dynamicContent;
    /**
     * 内容类型
     */
	@TableField("content_type")
	private Integer contentType;
    /**
     * 动态类型[【枚举：0-家长，1-老师】
     */
	@TableField("dynamic_type")
	private Integer dynamicType;
    /**
     * 关联宝贝IDs
     */
	@TableField("relation_baby_ids")
	private String relationBabyIds;
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
     * 是否同步到班级圈
     */
	private String sync;
	
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

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(String resourceSet) {
		this.resourceSet = resourceSet;
	}

	public String getDynamicContent() {
		return dynamicContent;
	}

	public void setDynamicContent(String dynamicContent) {
		this.dynamicContent = dynamicContent;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public Integer getDynamicType() {
		return dynamicType;
	}

	public void setDynamicType(Integer dynamicType) {
		this.dynamicType = dynamicType;
	}

	public String getRelationBabyIds() {
		return relationBabyIds;
	}

	public void setRelationBabyIds(String relationBabyIds) {
		this.relationBabyIds = relationBabyIds;
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

	public String getSync() {
		return sync;
	}

	public void setSync(String sync) {
		this.sync = sync;
	}
	

}
