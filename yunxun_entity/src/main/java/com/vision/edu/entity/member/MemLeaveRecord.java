package com.vision.edu.entity.member;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 请假记录表
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("mem_leave_record")
public class MemLeaveRecord extends Model<MemLeaveRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 老师/院长
     */
	private String addresseeid;
    /**
     * 请假人ID（用户ID）家长/老师
     */
	@TableField("member_id")
	private String memberId;
    /**
     * 请假人类型[枚举：0-宝贝，1-老师]
     */
	@TableField("member_type")
	private Integer memberType;
    /**
     * 班级ID
     */
	@TableField("class_id")
	private String classId;
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
     * 请假天数
     */
	@TableField("day_count")
	private Integer dayCount;
    /**
     * 请假时长
     */
	@TableField("when_long")
	private Integer whenLong;
    /**
     * 电话
     */
	private String telephone;
    /**
     * 请假事由
     */
	private String reason;
    /**
     * 状态
     */
	private Integer state;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 备注
     */
	private String remarks;
    /**
     * 请假类型
     */
	@TableField("leave_type")
	private Integer leaveType;
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
     * 审核标记
     */
	@TableField("check_flag")
	private Integer checkFlag;
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

	public String getAddresseeid() {
		return addresseeid;
	}

	public void setAddresseeid(String addresseeid) {
		this.addresseeid = addresseeid;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
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

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	public Integer getWhenLong() {
		return whenLong;
	}

	public void setWhenLong(Integer whenLong) {
		this.whenLong = whenLong;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(Integer leaveType) {
		this.leaveType = leaveType;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
