package com.vision.edu.enums;

/**
 * 引用标记：0-引用，1-创建
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumCiteFlag {
	/**
	 * 引用
	 */
	YY(0),
	/**
	 * 创建
	 */
	CJ(1);
	private final int value;

	EnumCiteFlag(int val) {
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
				text = "引用";
				break;
			case 1:
				text = "创建";
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
	public EnumCiteFlag get(int value) {
		for (EnumCiteFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
