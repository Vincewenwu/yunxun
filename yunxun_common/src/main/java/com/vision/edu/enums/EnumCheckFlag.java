package com.vision.edu.enums;

/**
 * 审核状态：0-未审核，1-已审核
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumCheckFlag {
	/**
	 * 未审核
	 */
	WSH(0),
	/**
	 * 已审核
	 */
	YSH(1),
	/**
	 * 不通过
	 */
	BTG(2);
	private final int value;

	EnumCheckFlag(int val) {
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
				text = "未审核";
				break;
			case 1:
				text = "已审核";
				break;
			case 2:
				text = "审核不通过";
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
	public EnumCheckFlag get(int value) {
		for (EnumCheckFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
