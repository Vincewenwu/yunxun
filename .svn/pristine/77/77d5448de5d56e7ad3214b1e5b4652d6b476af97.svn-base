package com.vision.edu.entity.system;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 后台用户
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * 后台用户ID
	 */
	private String id;
	/**
	 * 用户基本信息ID
	 */
	@TableField("base_member_id")
	private String baseMemberId;
	/**
	 * 用户名
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 最后登陆时间
	 */
	@TableField("last_login_time")
	private Date lastLoginTime;
	/**
	 * 默认用户角色ID
	 */
	@TableField("default_role_id")
	private String defaultRoleId;
	/**
	 * 停用否
	 */
	@TableField("disable_no")
	private Integer disableNo;
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
	/**
	 * 消息通知开关-老师
	 */
	@TableField("message_switch")
	private Integer messageSwitch;
	/**
	 * 职务id[仅针对老师]-老师
	 */
	@TableField("duties_id")
	private String dutiesId;
	/**
	 * 个性签名-老师
	 */
	private String signature;
	/**
	 * 绑定码-老师
	 */
	@TableField("binding_code")
	private String bindingCode;
	/**
	 * 后台用户类型【1-老师，3-园长，4-平台管理员】
	 */
	private Integer memberType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBaseMemberId() {
		return baseMemberId;
	}

	public void setBaseMemberId(String baseMemberId) {
		this.baseMemberId = baseMemberId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getDefaultRoleId() {
		return defaultRoleId;
	}

	public void setDefaultRoleId(String defaultRoleId) {
		this.defaultRoleId = defaultRoleId;
	}

	public Integer getDisableNo() {
		return disableNo;
	}

	public void setDisableNo(Integer disableNo) {
		this.disableNo = disableNo;
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

	public Integer getMessageSwitch() {
		return messageSwitch;
	}

	public void setMessageSwitch(Integer messageSwitch) {
		this.messageSwitch = messageSwitch;
	}

	public String getDutiesId() {
		return dutiesId;
	}

	public void setDutiesId(String dutiesId) {
		this.dutiesId = dutiesId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getBindingCode() {
		return bindingCode;
	}

	public void setBindingCode(String bindingCode) {
		this.bindingCode = bindingCode;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
