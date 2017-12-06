package com.vision.edu.entity.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 登录日志
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("sys_login_log")
public class SysLoginLog extends Model<SysLoginLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 园校id
     */
	@TableField("school_id")
	private String schoolId;
    /**
     * 登录IP地址
     */
	@TableField("login_ip")
	private String loginIp;
    /**
     * 浏览器内核
     */
	@TableField("browser_kernel")
	private String browserKernel;
    /**
     * 登录时间
     */
	@TableField("login_time")
	private Date loginTime;
    /**
     * 登录人ID
     */
	@TableField("login_user_id")
	private String loginUserId;
    /**
     * 退出时间
     */
	@TableField("bow_out_time")
	private Date bowOutTime;
    /**
     * 在线时长
     */
	@TableField("online_duration")
	private Integer onlineDuration;


	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getBrowserKernel() {
		return browserKernel;
	}

	public void setBrowserKernel(String browserKernel) {
		this.browserKernel = browserKernel;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public Date getBowOutTime() {
		return bowOutTime;
	}

	public void setBowOutTime(Date bowOutTime) {
		this.bowOutTime = bowOutTime;
	}

	public Integer getOnlineDuration() {
		return onlineDuration;
	}

	public void setOnlineDuration(Integer onlineDuration) {
		this.onlineDuration = onlineDuration;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}

}
