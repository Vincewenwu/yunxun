package com.vision.edu.enums;

/**
 * 日志类型：0-内容浏览，1-按钮点击
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumLogType {
	/**
	 * 内容浏览
	 */
	LL(1),
	/**
	 * 按钮点击
	 */
	DJ(0);
	private final int value;

	EnumLogType(int val) {
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
				text = "内容浏览";
				break;
			case 1:
				text = "按钮点击";
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
	public EnumLogType get(int value) {
		for (EnumLogType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
