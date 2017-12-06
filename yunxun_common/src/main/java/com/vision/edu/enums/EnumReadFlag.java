package com.vision.edu.enums;

/**
 * 也读标记：0-已阅读，1-为阅读
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumReadFlag {
	YYD(0), WYD(1);
	private final int value;

	EnumReadFlag(int val) {
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
				text = "已阅读";
				break;
			case 1:
				text = "未阅读";
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
	public EnumReadFlag get(int value) {
		for (EnumReadFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
