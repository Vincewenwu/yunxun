package com.vision.edu.enums;

/**
 * 动态类型：0-家长，1-老师
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumDynamicType {
	/**
	 * 家长
	 */
	JZ(0),
	/**
	 * 老师
	 */
	LS(1);
	private final int value;

	EnumDynamicType(int val) {
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
				text = "家长";
				break;
			case 1:
				text = "老师";
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
	public EnumDynamicType get(int value) {
		for (EnumDynamicType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
