package com.vision.edu.enums;

/**
 * 学期 ： 0-上学期，1-下学期
 * @author ChenYuanRong
 * @date 2017年7月27日10:30:04
 * @version 1.0
 */
public enum EnumTeam {

	/**
	 * 上学期
	 */
	LAST(0),
	/**
	 * 下学期
	 */
	NEXT(1);
	private final int value;

	EnumTeam(int val) {
		this.value = val;
	}
	
	
	/**
	 * 获取Text值
	 * @author ChenYuanRong
	 * @date 2017年7月27日10:30:04
	 * @return
	 */
	public String getText() {
		String text = null;
		switch (this.value) {
			case 0:
				text = "上学期";
				break;
			case 1:
				text = "下学期";
				break;
		}
		return text;
	}

	
	/**
	 * 获取value值
	 * @author  ChenYuanRong
	 * @date 2017年7月27日10:30:04
	 * @return
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * 通过值获取枚举
	 * @author  ChenYuanRong
	 * @date 2017年7月27日10:30:04
	 * @param value
	 * @return
	 */
	public EnumTeam get(int value) {
		for (EnumTeam item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
