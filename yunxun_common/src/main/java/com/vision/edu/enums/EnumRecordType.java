package com.vision.edu.enums;

/**
 * 签到记录类型：1-入校，2-出校，1-上车，2-下车
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumRecordType {
	/**
	 * 入校
	 */
	RX(1),
	/**
	 * 出校
	 */
	CX(2),
	/**
	 * 上车
	 */
	SC(3),
	/**
	 * 下车
	 */
	XC(4);

	private final int value;

	EnumRecordType(int val) {
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
			case 1:
				text = "入校";
				break;
			case 2:
				text = "出校";
				break;
			case 3:
				text = "上车";
				break;
			case 4:
				text = "下车";
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
	public static EnumRecordType get(int value) {
		for (EnumRecordType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
