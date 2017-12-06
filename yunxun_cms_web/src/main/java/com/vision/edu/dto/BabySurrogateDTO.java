package com.vision.edu.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;

/**
 *删除加同时删除接送人，用到的实体
 * @author ChenWenWu
 * @date 2017年7月12日 上午11:30:33
 * @version 1.0
 */
public class BabySurrogateDTO {
	
	private static final long serialVersionUID = 1L;
	
    
     /**
      * 宝贝ID
      */
     private String id;
     
     /**
      * 接送人ID
      */
     private String surrogateID;
     
     /**
      * 宝贝接送人ID
      */
     private String memsurrogateID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSurrogateID() {
		return surrogateID;
	}

	public void setSurrogateID(String surrogateID) {
		this.surrogateID = surrogateID;
	}

	public String getMemsurrogateID() {
		return memsurrogateID;
	}

	public void setMemsurrogateID(String memsurrogateID) {
		this.memsurrogateID = memsurrogateID;
	}


	
}
