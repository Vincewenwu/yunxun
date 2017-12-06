package com.vision.edu.framework.util;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

/**
 * 日期格式化工具类
 * springmvc日期字符换转换Date
 * @title 
 * @filename DateEditor.java
 * @author XieFan
 * @date 2017年4月13日 下午7:55:40
 * @version 1.0
 */
public class DateEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			if(StringUtils.isNotBlank(text)){
				date = format.parse(text);
			}
		} catch (ParseException e) {
			format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				date = format.parse(text);
			} catch (ParseException e1) {
				format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					date = format.parse(text);
				} catch (ParseException e12) {
					//处理  time 类型 ----jiangwangying
					format = new SimpleDateFormat("HH:mm:ss");
					try {
						date = format.parse(text);
					} catch (ParseException e13) {
						e13.printStackTrace();
					}
				}
			}
		}
		setValue(date);
	}
}

