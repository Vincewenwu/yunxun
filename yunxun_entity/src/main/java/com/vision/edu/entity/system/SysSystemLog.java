package com.vision.edu.entity.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统日志
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("sys_system_log")
public class SysSystemLog extends Model<SysSystemLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 园校id
     */
	@TableField("school_id")
	private String schoolId;
    /**
     * 操作人
     */
	@TableField("operator_id")
	private String operatorId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 执行方法
     */
	@TableField("execution_method")
	private String executionMethod;


	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getExecutionMethod() {
		return executionMethod;
	}

	public void setExecutionMethod(String executionMethod) {
		this.executionMethod = executionMethod;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}

}
