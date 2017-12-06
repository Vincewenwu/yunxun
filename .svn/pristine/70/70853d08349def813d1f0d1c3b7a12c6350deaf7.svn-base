package com.vision.edu.enums;

/**
 * 内容类型：0-视频，1-图文，2-文字
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumContentType {
	/**
	 * 视频
	 */
	SP(0),
	/**
	 * 图文
	 */
	TW(1),
	/**
	 * 文字
	 */
	WZ(2);
	private final int value;

	EnumContentType(int val) {
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
				text = "视频";
				break;
			case 1:
				text = "图文";
				break;
			case 2:
				text = "文字";
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
	public EnumContentType get(int value) {
		for (EnumContentType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
