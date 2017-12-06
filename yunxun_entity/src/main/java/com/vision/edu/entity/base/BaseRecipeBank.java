package com.vision.edu.entity.base;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 园校食谱库，用于记录园校的食谱库
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_recipe_bank")
public class BaseRecipeBank extends Model<BaseRecipeBank> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 平台食谱库id
     */
	@TableField("sys_recipe_bank_id")
	private String sysRecipeBankId;
    /**
     * 园校id
     */
	@TableField("school_id")
	private String schoolId;
    /**
     * 编号
     */
	@TableField("serial_num")
	private String serialNum;
    /**
     * 名称
     */
	private String name;
    /**
     * 封面
     */
	@TableField("cover_images")
	private String coverImages;
    /**
     * 图片集
     */
	@TableField("picture_set")
	private String pictureSet;
    /**
     * 简介
     */
	private String intro;
    /**
     * 食材
     */
	@TableField("food_material")
	private String foodMaterial;
    /**
     * 营养成分
     */
	private String nutrient;
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
     * 使用数
     */
	@TableField("used_count")
	private Integer usedCount;
    /**
     * 创建人
     */
	@TableField("create_mam")
	private String createMam;
    /**
     * 创建时间
     */
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
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
	@JSONField(format = "yyyy-MM-dd HH:mm:ss") 
	@TableField("update_time")
	private Date updateTime;
    /**
     * 0-引用，1-创建
     */
	@TableField("cite_flag")
	private Integer citeFlag;
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

	public String getSysRecipeBankId() {
		return sysRecipeBankId;
	}

	public void setSysRecipeBankId(String sysRecipeBankId) {
		this.sysRecipeBankId = sysRecipeBankId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
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

	public Integer getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
	}

	public String getCreateMam() {
		return createMam;
	}

	public void setCreateMam(String createMam) {
		this.createMam = createMam;
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

	public Integer getCiteFlag() {
		return citeFlag;
	}

	public void setCiteFlag(Integer citeFlag) {
		this.citeFlag = citeFlag;
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
