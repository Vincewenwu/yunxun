package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资讯组表
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_info_group")
public class MemInfoGroup extends Model<MemInfoGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 校园资讯ID
     */
	@TableField("school_info_id")
	private String schoolInfoId;
    /**
     * 学员组id
     */
	@TableField("base_group_id")
	private String baseGroupId;
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



	public String getSchoolInfoId() {
		return schoolInfoId;
	}



	public void setSchoolInfoId(String schoolInfoId) {
		this.schoolInfoId = schoolInfoId;
	}



	public String getBaseGroupId() {
		return baseGroupId;
	}



	public void setBaseGroupId(String baseGroupId) {
		this.baseGroupId = baseGroupId;
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



	@Override
	protected Serializable pkVal() {
		return null;
	}

}
