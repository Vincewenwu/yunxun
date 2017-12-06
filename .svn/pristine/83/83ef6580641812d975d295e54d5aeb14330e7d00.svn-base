package com.vision.edu.enums;

/**
 * 平台标记：0-平台，1-园校
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumPlatform {
	/**
	 * 平台
	 */
	PT(0),
	/**
	 * 园校
	 */
	YX(1);
	private final int value;

	EnumPlatform(int val) {
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
				text = "平台";
				break;
			case 1:
				text = "园校";
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
	public EnumPlatform get(int value) {
		for (EnumPlatform item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
