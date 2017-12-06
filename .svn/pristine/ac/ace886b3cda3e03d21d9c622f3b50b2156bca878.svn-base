package com.vision.edu.enums;

/**
 * 请假申请状态：0-待审批、1-已同意、2-已拒绝
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumLeaveState {
	/**
	 * 待审批
	 */
	DSP(0),
	/**
	 * 已同意
	 */
	TY(1),
	/**
	 * 已拒绝
	 */
	JJ(2);
	private final int value;

	EnumLeaveState(int val) {
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
				text = "待审批";
				break;
			case 1:
				text = "已同意";
				break;
			case 2:
				text = "已拒绝";
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
	public EnumLeaveState get(int value) {
		for (EnumLeaveState item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
