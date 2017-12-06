package com.vision.edu.enums;

/**
 * 用户类型：0-家长，1-老师，2-宝贝,3-院长
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumMemberType {
	/**
	 * 家长-0
	 */
	JZ(0),
	/**
	 * 老师-1
	 */
	LS(1),
	/**
	 * 宝贝-2
	 */
	BB(2),
	/**
	 * 院长-3
	 */
	YZ(3),
	/**
	 * 平台管理员-4
	 */
	PTGL(4);
	private final int value;

	EnumMemberType(int val) {
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
			case 2:
				text = "宝贝";
				break;
			case 3:
				text = "院长";
				break;

			case 4:
				text = "平台管理员";
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
	public EnumMemberType get(int value) {
		for (EnumMemberType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
