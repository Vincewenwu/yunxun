package com.vision.edu.enums;

/**
 * 点赞标记 0-点赞，1-取消点赞
 * @author zhangfeihong
 * @date 2017年7月6日 下午2:28:50
 * @version 1.0
 */
public enum EnumPraiseFlag {
	/**
	 * 点赞
	 */
	DZ(0),
	/**
	 * 取消点赞
	 */
	QXDZ(1);

	private final int value;

	EnumPraiseFlag(int v) {
		this.value = v;
	}

	/**
	 * 获取Text
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:33:00
	 * @return
	 */
	public String getText() {
		return this.value == 0 ? "点赞" : "取消点赞";
	}

	/**
	 * 获取value
	 * @author zhangfeihong
	 * @date 2017年7月6日 下午2:33:14
	 * @return
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * 通过值获取枚举
	 * <p>Title: get</p>
	 * <p>Description: </p>
	 * @param value
	 * @return
	 */
	public static EnumPraiseFlag get(int value) {
		for (EnumPraiseFlag item : values()) {
			if (item.value == value) {
				return item;
			}
		}
		return null;
	}
}
