package com.vision.edu.enums;

/**
 * 停用标记 0-未停用，1-已停用
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:28:50
 * @version 1.0
 */
public enum EnumDisableFlag {
	/**
	 * 未停用
	 */
	WTY(0),
	/**
	 * 已停用
	 */
	YTY(1);

	private final int value;

	EnumDisableFlag(int v) {
		this.value = v;
	}

	/**
	 * 获取Text
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:33:00
	 * @return
	 */
	public String getText() {
		return this.value == 0 ? "未停用" : "已停用";
	}

	/**
	 * 获取value
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:33:14
	 * @return
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * 通过值获取枚举
	 * <p>Title: get</p>
	 * <p>Description: </p>
	 * @param value
	 * @return
	 */
	public static EnumDisableFlag get(int value) {
		for (EnumDisableFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}
}
