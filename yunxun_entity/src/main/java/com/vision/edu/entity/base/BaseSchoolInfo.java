package com.vision.edu.entity.base;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 校园资讯
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_school_info")
public class BaseSchoolInfo extends Model<BaseSchoolInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 和校基本信息ID
	 */
	@TableField("school_id")
	private String schoolId;
	/**
	 * 资讯类型[枚举：0-公告，1-资讯，2-活动，3-banner]
	 */
	@TableField("info_type")
	private Integer infoType;
	/**
	 * 序号
	 */
	@TableField("serial_num")
	private Integer serialNum;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 封面图片集
	 */
	@TableField("cover_images")
	private String coverImages;
	/**
	 * 开始时间
	 */
	@TableField("start_time")
	private Date startTime;
	/**
	 * 结束时间
	 */
	@TableField("end_time")
	private Date endTime;
	/**
	 * 链接[如果为空，则显示内容]
	 */
	private String link;
	/**
	 * 浏览数
	 */
	@TableField("browse_count")
	private Integer browseCount;
	/**
	 * 评论数
	 */
	@TableField("comment_count")
	private Integer commentCount;
	/**
	 * 报名数
	 */
	@TableField("apply_count")
	private Integer applyCount;
	/**
	 * 点赞数
	 */
	@TableField("point_count")
	private Integer pointCount;
	/**
	 * 收藏数
	 */
	@TableField("collection_count")
	private Integer collectionCount;
	/**
	 * 范围类型
	 */
	@TableField("range_type")
	private Integer rangeType;
	/**
	 * 创建时间
	 */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
	 * 审核时间
	 */
	@TableField("check_time")
	private Date checkTime;
	/**
	 * 审核人
	 */
	@TableField("check_man")
	private String checkMan;
	/**
	 * 0-审核，1-已审核
	 */
	@TableField("check_flag")
	private Integer checkFlag;
	/**
	 * 0-未删除，1-已删除
	 */
	@TableField("delete_flag")
	private Integer deleteFlag;
	/**
	 * 内容图片集
	 */
	@TableField("content_imgs")
	private String contentImgs;

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
	 * 平台标记
	 */
	@TableField("platform_flag")
	private Integer platformFlag;

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

	public Integer getInfoType() {
		return infoType;
	}

	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

	public Integer getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(Integer serialNum) {
		this.serialNum = serialNum;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCoverImages() {
		return coverImages;
	}

	public void setCoverImages(String coverImages) {
		this.coverImages = coverImages;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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

	public Integer getCollectionCount() {
		return collectionCount;
	}

	public void setCollectionCount(Integer collectionCount) {
		this.collectionCount = collectionCount;
	}

	public Integer getRangeType() {
		return rangeType;
	}

	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
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

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckMan() {
		return checkMan;
	}

	public void setCheckMan(String checkMan) {
		this.checkMan = checkMan;
	}

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getContentImgs() {
		return contentImgs;
	}

	public void setContentImgs(String contentImgs) {
		this.contentImgs = contentImgs;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
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

	public Integer getPlatformFlag() {
		return platformFlag;
	}

	public void setPlatformFlag(Integer platformFlag) {
		this.platformFlag = platformFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}


}
