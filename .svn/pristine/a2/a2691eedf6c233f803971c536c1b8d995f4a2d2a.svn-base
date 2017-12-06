package com.vision.edu.enums;

/**
 * 提醒消息类型：0-吃药，1-签到，2-放假，3-作业，4-通知, 5-加餐,6-情绪 
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumMessageType {
	/**
	 * 吃药
	 */
	CY(0),
	/**
	 * 签到
	 */
	QD(1),
	/**
	 * 放假
	 */
	FJ(2),
	/**
	 * 作业
	 */
	ZY(3),
	/**
	 * 通知
	 */
	JC(4),
	/**
	 * 加餐
	 */
	QX(5),
	/**
	 * 情绪 
	 */
	TZ(6);
	private final int value;

	EnumMessageType(int val) {
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
				text = "吃药";
				break;
			case 1:
				text = "签到";
				break;
			case 2:
				text = "放假";
				break;
			case 3:
				text = "作业";
				break;
			case 4:
				text = "通知";
				break;
			case 5:
				text = "加餐";
				break;
			case 6:
				text = "情绪";
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
	public EnumMessageType get(int value) {
		for (EnumMessageType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
