package com.vision.edu.enums;

/**
 * 请假类型：0-病假，1-事假
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumLeaveType {
	/**
	 * 病假
	 */
	BJ(0),
	/**
	 * 事假
	 */
	SJ(1);
	private final int value;

	EnumLeaveType(int val) {
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
				text = "病假";
				break;
			case 1:
				text = "事假";
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
	public EnumLeaveType get(int value) {
		for (EnumLeaveType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
