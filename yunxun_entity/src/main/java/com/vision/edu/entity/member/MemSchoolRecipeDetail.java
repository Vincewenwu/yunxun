package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 园校食谱明细，用于记录每天的餐时
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_school_recipe_detail")
public class MemSchoolRecipeDetail extends Model<MemSchoolRecipeDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 园校食谱id
     */
	@TableField("school_recipe_id")
	private String schoolRecipeId;
    /**
     * 园校食谱库id
     */
	@TableField("base_recipe_bank_id")
	private String baseRecipeBankId;
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
     * 餐次[枚举：0-早餐，1-午餐，2-晚餐]
     */
	@TableField("several_meals")
	private Integer severalMeals;
    /**
     * 创建人
     */
	@TableField("create_mam")
	private String createMam;
    /**
     * 创建时间
     */
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
	@TableField("update_time")
	private Date updateTime;
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

	public String getSchoolRecipeId() {
		return schoolRecipeId;
	}

	public void setSchoolRecipeId(String schoolRecipeId) {
		this.schoolRecipeId = schoolRecipeId;
	}

	public String getBaseRecipeBankId() {
		return baseRecipeBankId;
	}

	public void setBaseRecipeBankId(String baseRecipeBankId) {
		this.baseRecipeBankId = baseRecipeBankId;
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

	public Integer getSeveralMeals() {
		return severalMeals;
	}

	public void setSeveralMeals(Integer severalMeals) {
		this.severalMeals = severalMeals;
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
