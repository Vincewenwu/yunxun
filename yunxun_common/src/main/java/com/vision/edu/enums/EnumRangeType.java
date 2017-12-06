package com.vision.edu.enums;

/**
 * 范围类型枚举：0-全平台，1-全园校，2-分组推送
 * @author XieFan
 * @date 2017年7月16日 下午4:37:40
 * @version 1.0
 */
public enum EnumRangeType {
	/**
	 * 全平台
	 */
	QPT(0),
	/**
	 * 全园校
	 */
	QYX(1),
	/**
	 * 分组推送
	 */
	FZTS(2);
	private final int value;

	EnumRangeType(int val) {
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
				text = "全平台";
				break;
			case 1:
				text = "全园校";
				break;
			case 2:
				text = "分组推送";
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
	public static EnumRangeType get(int value) {
		for (EnumRangeType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
