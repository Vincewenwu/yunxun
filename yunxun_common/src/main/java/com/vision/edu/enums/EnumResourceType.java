package com.vision.edu.enums;

/**
 * 资源类型：0-食谱，1-签到，2-成长轨迹，3-动态，4-公告，5-资讯，6-活动，7-banner
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumResourceType {
	/**
	 * 食谱
	 */
	SP(0),
	/**
	 * 签到
	 */
	QD(1),
	/**
	 * 成长轨迹
	 */
	CZGJ(2),
	/**
	 * 动态
	 */
	DT(3),
	/**
	 * 公告
	 */
	GG(4),
	/**
	 * 资讯
	 */
	ZX(5),
	/**
	 * 活动
	 */
	HD(6),
	/**
	 * banner
	 */
	BN(7),
	/**
	 * 育儿知识
	 */
	YRZS(8),
	/**
	 * 院长
	 */
	YZ(9),
	/**
	 * 老师
	 */
	LS(10),
	/**
	 * 评论
	 */
	PL(11);
	private final int value;

	EnumResourceType(int val) {
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
				text = "食谱";
				break;
			case 1:
				text = "签到";
				break;
			case 2:
				text = "成长轨迹";
				break;
			case 3:
				text = "动态";
				break;
			case 4:
				text = "公告";
				break;
			case 5:
				text = "资讯";
				break;
			case 6:
				text = "活动";
				break;
			case 7:
				text = "banner";
				break;
			case 8:
				text = "育儿知识";
				break;
			case 9:
				text = "院长";
				break;
			case 10:
				text = "老师";
				break;
			case 11:
				text = "评论";
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
	public static EnumResourceType get(int value) {
		for (EnumResourceType item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}

}
