package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 报名记录
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_apply_record")
public class MemApplyRecord extends Model<MemApplyRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 会员id
     */
	@TableField("member_id")
	private String memberId;
    /**
     * 来源类型[枚举：0-成长轨迹，1-食谱，2-公告，3-资讯，4-活动，5-banner]
     */
	@TableField("resources_type")
	private Integer resourcesType;
    /**
     * 源id
     */
	@TableField("resources_id")
	private String resourcesId;
    /**
     * 姓名
     */
	private String name;
    /**
     * 性别[枚举：0-男，1-女，2-其他]
     */
	private Integer sex;
    /**
     * 手机号
     */
	@TableField("phone_num")
	private String phoneNum;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 删除标记
     */
	@TableField("delete_flag")
	private Integer deleteFlag;
    /**
     * 备注
     */
	private String remark;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getResourcesType() {
		return resourcesType;
	}

	public void setResourcesType(Integer resourcesType) {
		this.resourcesType = resourcesType;
	}

	public String getResourcesId() {
		return resourcesId;
	}

	public void setResourcesId(String resourcesId) {
		this.resourcesId = resourcesId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
