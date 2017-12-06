package com.vision.edu.enums;

/**
 * 资讯类型：0-公告，1-资讯，2-活动，3-banner
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumInfoType {
	/**
	 * 公告
	 */
	GG(0),
	/**
	 * 资讯
	 */
	ZX(1),
	/**
	 * 活动
	 */
	HD(2),
	/**
	 * banner
	 */
	BN(3);
	private final int value;

	EnumInfoType(int val) {
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
				text = "公告";
				break;
			case 1:
				text = "资讯";
				break;
			case 2:
				text = "活动";
				break;
			case 3:
				text = "Banner";
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
	public EnumInfoType get(int value) {
		for (EnumInfoType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
