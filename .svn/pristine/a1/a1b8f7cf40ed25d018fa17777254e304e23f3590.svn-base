package com.vision.edu.entity.base;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 地区
 * </p>
 *
 * @author XieFan
 * @since 2017-07-13
 */
@TableName("base_district")
public class BaseDistrict extends Model<BaseDistrict> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Integer id;
    /**
     * 代码
     */
	private String code;
    /**
     * 名称
     */
	private String name;
    /**
     * 父id
     */
	private String pid;
    /**
     * 等级
     */
	private Integer level;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
