/**
 * 
 */
package com.vision.edu.dto;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;

/*
 *这是点赞记录的模型
*@author:zyml
*@date:2017年7月8日下午9:28:57
*/
public class CampusInformationDTO implements Serializable{
	

    /**
     * 点赞人ID
     */
	@TableField("member_id")
	private String memberId;
	
	 /**
     * 评论内容
     */
	private String comment;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 点赞类型
     */
	@TableField("praise_type")
	private Integer praiseType;
    /**
     * 来源ID
     */
	@TableField("source_id")
	private String sourceId;
    /**
     * 是否取消
     */
	@TableField("cancel_no")
	private Integer cancelNo;
    /**
     * 修改时间
     */
	@TableField("update_time")
	private Date updateTime;
   
	 /**
     * 头像
     */
	@TableField("head_portrait")
	private String headPortrait;
	
	
	 /**
     * 姓名
     */
	private String name;
	
	/**
	 * 点赞数
	 */
	private String pcount;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getPraiseType() {
		return praiseType;
	}

	public void setPraiseType(Integer praiseType) {
		this.praiseType = praiseType;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getCancelNo() {
		return cancelNo;
	}

	public void setCancelNo(Integer cancelNo) {
		this.cancelNo = cancelNo;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPcount() {
		return pcount;
	}

	public void setPcount(String pcount) {
		this.pcount = pcount;
	}
  

	
 
}
