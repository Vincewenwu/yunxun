package com.vision.edu.enums;

/**
 * 关于我的类型：0-功能介绍，1-常见问题，2-技术支持，3-运营支持
 * @author zhangfeihong
 * @date 2017年8月11日 上午9:10:53
 * @version 1.0
 */
public enum EnumAboutType {
	/**
	 * 功能介绍
	 */
	GNJS(0),
	/**
	 * 常见问题
	 */
	CJWT(1),
	/**
	 * 技术支持
	 */
	JSZC(2),
	/**
	 * 运营支持
	 */
	YYZC(3);
	private final int value;

	EnumAboutType(int val) {
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
				text = "功能介绍";
				break;
			case 1:
				text = "常见问题";
			break;
			case 2:
				text = "技术支持";
			break;
			case 3:
				text = "运营支持";
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
	public EnumAboutType get(int value) {
		for (EnumAboutType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
