package com.vision.edu.dto;
/**
 * 标签管理
 * @author ChenWenWu
 * @date 2017年8月2日 下午3:06:31
 * @version 1.0
 */
public class BaseLableShoolDTO {
	/**
	 * 标签ID
	 */
    private String id;
    /**
	 * 标签名称
	 */
    private String lableName;
     /**
	  * 标签类型
	  */
    private String lebleType;
    /**
	 * 生成人
	 */
   private String createMan;
   /**
	 * 生成时间
	 */
  private String createTime;
  /**
	 * 删除否
	 */
 private String  deleteFlag;
 /**
	 * 院校ID
	 */
private String shoolName;
 /**
  * 学院ID
  */
private String shoolID;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getLableName() {
	return lableName;
}
public void setLableName(String lableName) {
	this.lableName = lableName;
}
public String getLebleType() {
	return lebleType;
}
public void setLebleType(String lebleType) {
	this.lebleType = lebleType;
}
public String getCreateMan() {
	return createMan;
}
public void setCreateMan(String createMan) {
	this.createMan = createMan;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getDeleteFlag() {
	return deleteFlag;
}
public void setDeleteFlag(String deleteFlag) {
	this.deleteFlag = deleteFlag;
}
public String getShoolName() {
	return shoolName;
}
public void setShoolName(String shoolName) {
	this.shoolName = shoolName;
}
public String getShoolID() {
	return shoolID;
}
public void setShoolID(String shoolID) {
	this.shoolID = shoolID;
}


   
}
