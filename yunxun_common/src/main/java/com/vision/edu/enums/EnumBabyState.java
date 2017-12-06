package com.vision.edu.enums;

/**
 * 宝贝账状态：0-正常，1-未付费，2-已过期
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumBabyState {
	/**
	 * 正常-0
	 */
	ZC(0),
	/**
	 * 未付费-1
	 */
	WFF(1),
	/**
	 * 已过期-2
	 */
	YGQ(2);

	private final int value;

	EnumBabyState(int val) {
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
				text = "未付费";
				break;
			case 2:
				text = "已过期";
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
	public EnumBabyState get(int value) {
		for (EnumBabyState item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
