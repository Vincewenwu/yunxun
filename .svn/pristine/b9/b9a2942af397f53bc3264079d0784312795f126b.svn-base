package com.vision.edu.enums;

/**
 * 订单类型：0-平台服务，1-在线资源
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumOrderType {
	/**
	 * 平台服务
	 */
	PTFW(0),
	/**
	 * 在线资源
	 */
	ZXZY(1);
	private final int value;

	EnumOrderType(int val) {
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
				text = "平台服务";
				break;
			case 1:
				text = "在线资源";
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
	public EnumOrderType get(int value) {
		for (EnumOrderType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
