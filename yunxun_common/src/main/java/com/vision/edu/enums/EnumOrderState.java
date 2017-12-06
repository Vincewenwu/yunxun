package com.vision.edu.enums;

/**
 * 订单状态：0-未支付，1-已支付，2-退款中，3-已退款
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumOrderState {
	/**
	 * 未支付-0
	 */
	WZF(0),
	/**
	 * 已支付-1
	 */
	YZF(1),
	/**
	 * 退款中-2
	 */
	TKZ(2),
	/**
	 * 已退款-3
	 */
	YTK(3);
	private final int value;

	EnumOrderState(int val) {
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
				text = "未支付";
				break;
			case 1:
				text = "已支付";
				break;
			case 2:
				text = "退款中";
				break;
			case 3:
				text = "已退款";
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
	public EnumOrderState get(int value) {
		for (EnumOrderState item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
