package com.vision.edu.enums;

/**
 * 消息状态：0-未读，1-已读，2-已回复
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumMessageState {
	/**
	 * 未读
	 */
	WD(0),
	/**
	 * 已读
	 */
	YD(1),
	/**
	 * 已回复
	 */
	YHF(2);
	private final int value;

	EnumMessageState(int val) {
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
				text = "未读";
				break;
			case 1:
				text = "已读";
				break;
			case 2:
				text = "已回复";
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
	public EnumMessageState get(int value) {
		for (EnumMessageState item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
