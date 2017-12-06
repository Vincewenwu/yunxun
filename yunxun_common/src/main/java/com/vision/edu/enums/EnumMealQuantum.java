package com.vision.edu.enums;

/**
 * 餐次类型：0-早餐，1-午餐，2-晚餐
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumMealQuantum {
	/**
	 * 早餐
	 */
	ZC(0),
	/**
	 * 午餐
	 */
	WUC(1),
	/**
	 * 晚餐
	 */
	WAC(2);

	private final int value;

	EnumMealQuantum(int val) {
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
				text = "早餐";
				break;
			case 1:
				text = "午餐";
				break;
			case 2:
				text = "晚餐";
				break;
			case 3:
				text = "活动";
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
	public EnumMealQuantum get(int value) {
		for (EnumMealQuantum item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
