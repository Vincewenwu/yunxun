package com.vision.edu.enums;

/**
 * 性别类型：0-男，1-女
 * @author chenwenwu
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumSexType {
	/**
	 * 男
	 */
	NAN(0),
	/**
	 * 女
	 */
	NV(1);
	private final int value;

	EnumSexType(int val) {
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
				text = "男";
				break;
			case 1:
				text = "女";
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
	public EnumSexType get(int value) {
		for (EnumSexType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
