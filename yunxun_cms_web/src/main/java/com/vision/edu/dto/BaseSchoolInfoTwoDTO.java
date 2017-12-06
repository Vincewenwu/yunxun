package com.vision.edu.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;


public class BaseSchoolInfoTwoDTO extends Model<BaseSchoolInfoTwoDTO> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 和校基本信息ID
     */
	private String schoolId;
    /**
     * 资讯类型[枚举]
     */
	private Integer infoType;
    /**
     * 序号
     */
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
	private String coverImages;
    /**
     * 开始时间
     */
	  @JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date startTime;
    /**
     * 结束时间
     */
	  @JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date endTime;
    /**
     * 链接
     */
	private String link;
    /**
     * 浏览数
     */
	private Integer browseCount;
    /**
     * 点赞数
     */
	private Integer pointCount;
    /**
     * 收藏数
     */
	private Integer collectionCount;
    /**
     * 全园否
     */
	private Integer wholeSchoolNo;
    /**
     * 创建时间
     */
	 @JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date createTime;
    /**
     * 创建人
     */
	private String createMam;
    /**
     * 修改时间
     */
	 @JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date updateTime;
    /**
     * 修改人
     */
	private String updateMan;
    /**
     * 审核时间
     */
	 @JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	private Date checkTime;
    /**
     * 审核人
     */
	private String checkMan;
    /**
     * 0-审核，1-已审核
     */
	private Integer checkFlag;
    /**
     * 0-未删除，1-已删除
     */
	private Integer deleteFlag;

//	以下加入的字段
	/**
	 * 学校名称
	 */
    private String shool_name;
    
    /**
     * 范围类型
     */
    private Integer rangeType;
    
	 /**
	  * 咨询组表的主键
	  */
   private String baseGroupId;
   /**
    * 平台标记
    */
   private String platformFlag;
   
	public String getPlatformFlag() {
	return platformFlag;
}



public void setPlatformFlag(String platformFlag) {
	this.platformFlag = platformFlag;
}



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



	public Integer getWholeSchoolNo() {
		return wholeSchoolNo;
	}



	public void setWholeSchoolNo(Integer wholeSchoolNo) {
		this.wholeSchoolNo = wholeSchoolNo;
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



	public String getShool_name() {
		return shool_name;
	}



	public void setShool_name(String shool_name) {
		this.shool_name = shool_name;
	}



	public Integer getRangeType() {
		return rangeType;
	}



	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}


	public String getBaseGroupId() {
		return baseGroupId;
	}



	public void setBaseGroupId(String baseGroupId) {
		this.baseGroupId = baseGroupId;
	}



	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
