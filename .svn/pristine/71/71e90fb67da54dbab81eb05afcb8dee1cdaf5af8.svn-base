package com.vision.edu.enums;

/**
 * 套餐状态：0-正常，1-过期
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumComboStatus {
	/**
	 * 正常
	 */
	ZC(0),
	/**
	 * 过期
	 */
	GQ(1);
	private final int value;

	EnumComboStatus(int val) {
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
				text = "过期";
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
	public EnumComboStatus get(int value) {
		for (EnumComboStatus item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
