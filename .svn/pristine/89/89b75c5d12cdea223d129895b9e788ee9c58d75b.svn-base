package com.vision.edu.enums;

/**
 * 删除标记 0-未删除，1-已删除
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:28:50
 * @version 1.0
 */
public enum EnumDeleteFlag {
	/**
	 * 未删除
	 */
	 WSC(0),
	/**
	 * 已删除
	 */
	 YSC(1);
	

	private final int value;

	EnumDeleteFlag(int v) {
		this.value = v;
	}

	/**
	 * 获取Text
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:33:00
	 * @return
	 */
	public String getText() {
		return this.value == 0 ? "未删除" : "已删除";
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
	public static EnumDeleteFlag get(int value) {
		for (EnumDeleteFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}
}
