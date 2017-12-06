package com.vision.edu.enums;

/**
 * 发布状态：0-未发布，1-已发布
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumPublishFlag {
	/**
	 * 未发布
	 */
	YFB(1),
	/**
	 * 已发布
	 */
	WFB(0);

	private final int value;

	EnumPublishFlag(int val) {
		this.value = val;
	}

	/**
	 * 获取Text值
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:48:09
	 * @return
	 */
	public String getText() {
		return this.value == 0 ? "未发布" : "已发布";
	}

	/**
	 * 通过值获取枚举
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:50:59
	 * @param value
	 * @return
	 */
	public EnumPublishFlag get(int value) {
		for (EnumPublishFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
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
}
