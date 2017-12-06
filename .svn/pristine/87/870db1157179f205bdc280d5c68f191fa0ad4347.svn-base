package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 育儿知识
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_parenting_knowledge")
public class BaseParentingKnowledge extends Model<BaseParentingKnowledge> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 发布者ID
	 */
	@TableField("publisher_id")
	private String publisherId;
	/**
	 * 序号
	 */
	@TableField("serial_num")
	private Integer serialNum;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 标签id
	 */
	@TableField("leble_id")
	private String lebleId;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * url链接
	 */
	private String url;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 下架否
	 */
	@TableField("disable_no")
	private Integer disableNo;
	
	
	/**
	 * 当前成员点赞记录id
	 */
	@TableField(exist = false)
	private String praiseId;

	/**
	 * 当前成员点赞状态
	 */
	@TableField(exist = false)
	private String cancelNo;
	

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
	 * 评论数
	 */
	@TableField("comment_count")
	private Integer commentCount;
	/**
	 * 收藏数
	 */
	@TableField("collection_num")
	private Integer collectionNum;
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
	 * 展示开始时间
	 */
	@TableField("start_time")
	private Date startTime;
	/**
	 * 展示结束时间
	 */
	@TableField("end_time")
	private Date endTime;

	/**
	 * 范围类型
	 */
	@TableField("range_type")
	private Integer rangeType;

	/**
	 * 园校id
	 */
	@TableField("school_id")
	private String schoolId;


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

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getLebleId() {
		return lebleId;
	}

	public void setLebleId(String lebleId) {
		this.lebleId = lebleId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getDisableNo() {
		return disableNo;
	}

	public void setDisableNo(Integer disableNo) {
		this.disableNo = disableNo;
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

	public Integer getCollectionNum() {
		return collectionNum;
	}

	public void setCollectionNum(Integer collectionNum) {
		this.collectionNum = collectionNum;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}


	public String getPraiseId() {
		return praiseId;
	}

	public void setPraiseId(String praiseId) {
		this.praiseId = praiseId;
	}

	public String getCancelNo() {
		return cancelNo;
	}

	public void setCancelNo(String cancelNo) {
		this.cancelNo = cancelNo;
	}
	
	
	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}


}
