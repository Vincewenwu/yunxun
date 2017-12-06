package com.vision.edu.enums;

/**
 * 院校状态：0-正常，1-已过期，2-未开通
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumSchoolState {
	/**
	 * 正常
	 */
	ZC(0),
	/**
	 * 已过期
	 */
	YGQ(1),
	/**
	 * 未开通
	 */
	WKT(2);
	private final int value;

	EnumSchoolState(int val) {
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
				text = "正常";
				break;
			case 1:
				text = "已过期";
				break;
			case 2:
				text = "未开通";
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
	public EnumSchoolState get(int value) {
		for (EnumSchoolState item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
