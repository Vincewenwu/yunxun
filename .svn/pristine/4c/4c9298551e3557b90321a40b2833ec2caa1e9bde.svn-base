package com.vision.edu.enums;

/**
 * 支付方法：0-微信支付，1-系统开通
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumPaymentType {
	/**
	 * 微信支付
	 */
	WXZF(0),
	/**
	 * 系统开通
	 */
	XTKT(1);
	private final int value;

	EnumPaymentType(int val) {
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
				text = "微信支付";
				break;
			case 1:
				text = "系统开通";
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
	public EnumPaymentType get(int value) {
		for (EnumPaymentType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
