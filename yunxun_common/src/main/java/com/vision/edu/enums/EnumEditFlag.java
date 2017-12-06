package com.vision.edu.enums;

/**
 * 编辑标记：0-可编辑，1-不可编辑
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumEditFlag {
	/**
	 * 可编辑
	 */
	YY(0),
	/**
	 * 不可编辑
	 */
	CJ(1);
	private final int value;

	EnumEditFlag(int val) {
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
				text = "可编辑";
				break;
			case 1:
				text = "不可编辑";
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
	public EnumEditFlag get(int value) {
		for (EnumEditFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
