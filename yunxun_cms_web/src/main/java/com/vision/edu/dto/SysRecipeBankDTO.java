package com.vision.edu.dto;

import java.util.Date;

/**
 * 营养餐谱  
 * @author ChenWenWu
 * @date 2017年7月10日 上午11:28:30
 * @version 1.0
 */
public class SysRecipeBankDTO {

	
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 编号
	 */
	private String serialNum;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 封面
	 */
	private String coverImages;
	/**
	 * 图片集
	 */
	private String pictureSet;
	/**
	 * 简介
	 */
	private String intro;
	/**
	 * 食材
	 */
	private String foodMaterial;
	/**
	 * 营养成分
	 */
	private String nutrient;
	/**
	 * 平台录入标记
	 */
	private Integer terraceFlag;
	/**
	 * 上传园所id
	 */
	private String schoolId;
	/**
	 * 使用数
	 */
	private Integer usedCount;
	/**
	 * 浏览数
	 */
	private Integer browseCount;
	/**
	 * 点赞数
	 */
	private Integer pointCount;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 创建人
	 */
	private String createMam;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改人
	 */
	private String updateMan;
	/**
	 * 0-未删除，1-已删除
	 */
	private Integer deleteFlag;
	/**
	 * 0-展示，1-不展示
	 */
	private Boolean showFlag;

//   private String name;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoverImages() {
		return coverImages;
	}

	public void setCoverImages(String coverImages) {
		this.coverImages = coverImages;
	}

	public String getPictureSet() {
		return pictureSet;
	}

	public void setPictureSet(String pictureSet) {
		this.pictureSet = pictureSet;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getFoodMaterial() {
		return foodMaterial;
	}

	public void setFoodMaterial(String foodMaterial) {
		this.foodMaterial = foodMaterial;
	}

	public String getNutrient() {
		return nutrient;
	}

	public void setNutrient(String nutrient) {
		this.nutrient = nutrient;
	}

	public Integer getTerraceFlag() {
		return terraceFlag;
	}

	public void setTerraceFlag(Integer terraceFlag) {
		this.terraceFlag = terraceFlag;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
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

	public Boolean getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(Boolean showFlag) {
		this.showFlag = showFlag;
	}

//	public String getSchoolName() {
//		return schoolName;
//	}
//
//	public void setSchoolName(String schoolName) {
//		this.schoolName = schoolName;
//	}
	
}
