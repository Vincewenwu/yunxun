package com.vision.edu.enums;

/**
 * 宝贝账号激活状态：0-未激活，1-已激活
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumActiveStatue {
	/**
	 * 未审核
	 */
	WJH(0),
	/**
	 * 已审核
	 */
	YJH(1);
	private final int value;

	EnumActiveStatue(int val) {
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
				text = "未激活";
				break;
			case 1:
				text = "已激活";
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
	public EnumActiveStatue get(int value) {
		for (EnumActiveStatue item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
