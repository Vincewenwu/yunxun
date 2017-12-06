package com.vision.edu.entity.system;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *系统模块
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("sys_modular")
public class SysModular extends Model<SysModular> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 模块名称
     */
	private String name;
    /**
     * 父ID
     */
	@TableField("father_id")
	private String fatherId;
    /**
     * URL
     */
	private String url;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 创建人
     */
	@TableField("creat_man")
	private String creatMan;
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
	 * 菜单类型
	 */
	private Integer muneType;
	
    /*  ===========================扩展字段=========================   */
	@TableField(exist = false)
	private String pageFatherId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreatMan() {
		return creatMan;
	}

	public void setCreatMan(String creatMan) {
		this.creatMan = creatMan;
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
		return this.id;
	}

	public Integer getMuneType() {
		return muneType;
	}

	public void setMuneType(Integer muneType) {
		this.muneType = muneType;
	}

	public String getPageFatherId() {
		return pageFatherId;
	}

	public void setPageFatherId(String pageFatherId) {
		this.pageFatherId = pageFatherId;
	}

}
