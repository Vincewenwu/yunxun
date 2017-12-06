package com.vision.edu.enums;

/**
 * 亲属关系类型：0-爸爸，1-妈妈，2-爷爷，3-奶奶，4-外公，5-外婆，6-邻居，7-哥哥，8-姐姐，9-叔叔，10-婶婶,11-保姆
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:44:19
 * @version 1.0
 */
public enum EnumRelationship {
	/**
	 * 爸爸
	 */
	BB(0),
	/**
	 * 妈妈
	 */
	MM(1),
	/**
	 * 爷爷
	 */
	YY(2),
	/**
	 * 奶奶
	 */
	NN(3),
	/**
	 * 外公
	 */
	WG(4),
	/**
	 * 外婆
	 */
	WP(5),
	/**
	 * 邻居
	 */
	LJ(6),
	/**
	 * 哥哥
	 */
	GG(7),
	/**
	 * 姐姐
	 */
	JJ(8),
	/**
	 * 叔叔
	 */
	SU(9),
	/**
	 * 婶婶
	 */
	SE(10),
	/**
	 * 保姆
	 */
	BM(11);
	private final int value;

	EnumRelationship(int val) {
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
				text = "爸爸";
				break;
			case 1:
				text = "妈妈";
				break;
			case 2:
				text = "爷爷";
				break;
			case 3:
				text = "奶奶";
				break;
			case 4:
				text = "外公";
				break;
			case 5:
				text = "外婆";
				break;
			case 6:
				text = "邻居";
				break;
			case 7:
				text = "哥哥";
				break;
			case 8:
				text = "姐姐";
				break;
			case 9:
				text = "叔叔";
				break;
			case 10:
				text = "婶婶";
				break;
			case 11:
				text = "保姆";
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
	public static EnumRelationship get(int value) {
		for (EnumRelationship item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}


}
