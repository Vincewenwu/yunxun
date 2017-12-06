package com.vision.edu.enums;

/**
 * 组类型：0-宝贝，1-教师
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumGroupType {
	/**
	 * 宝贝
	 */
	BB(0),
	/**
	 * 教师
	 */
	JS(1);
	private final int value;

	EnumGroupType(int val) {
		this.value = val;
	}

	/**
	 * 获取Text值
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:48:09
	 * @return
	 */
	public String getText() {
		String text = null;
		switch (this.value) {
			case 0:
				text = "宝贝";
				break;
			case 1:
				text = "教师";
				break;
		}
		return text;
	}

	/**
	 * 获取value值
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:48:46
	 * @return
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * 通过值获取枚举
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:50:59
	 * @param value
	 * @return
	 */
	public EnumGroupType get(int value) {
		for (EnumGroupType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}
}
