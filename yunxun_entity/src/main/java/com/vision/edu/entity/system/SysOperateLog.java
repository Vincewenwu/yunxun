package com.vision.edu.entity.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 客户操作日志
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("sys_operate_log")
public class SysOperateLog extends Model<SysOperateLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 园校id
     */
	@TableField("school_id")
	private String schoolId;
    /**
     * 点赞人ID
     */
	@TableField("member_id")
	private String memberId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 来源类型
     */
	@TableField("praise_type")
	private Integer praiseType;
    /**
     * 来源ID
     */
	@TableField("source_id")
	private Integer sourceId;
    /**
     * 浏览时长
     */
	@TableField("when_long")
	private Integer whenLong;
    /**
     * 日志类型【枚举：0-内容浏览，1-按钮点击】
     */
	@TableField("log_type")
	private Integer logType;
    /**
     * 按钮名称
     */
	@TableField("btn_name")
	private String btnName;
    /**
     * 访问链接
     */
	private String url;


	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getWhenLong() {
		return whenLong;
	}

	public void setWhenLong(Integer whenLong) {
		this.whenLong = whenLong;
	}

	public Integer getLogType() {
		return logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public String getBtnName() {
		return btnName;
	}

	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}

}
