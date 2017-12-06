package com.vision.edu.enums;

/**
 * 签到状态：0-待签，1-已签，2-补签，3-请假
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumRecordState {
	/**
	 * 待签
	 */
	DQ(0),
	/**
	 * 已签
	 */
	YQ(1),
	/**
	 * 补签
	 */
	BQ(2),
	/**
	 * 缺勤
	 */
	QQ(3),
	/**
	 * 请假
	 */
	QJ(4);
	private final int value;

	EnumRecordState(int val){
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
				text = "待签";
				break;
			case 1:
				text = "已签";
				break;
			case 2:
				text = "补签";
				break;
			case 3:
				text = "缺勤";
				break;
			case 4:
				text = "请假";
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
	public EnumRecordState get(int value) {
		for (EnumRecordState item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
