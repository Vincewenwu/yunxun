package com.vision.edu.enums;

/**
 * 老师点击确认标记 【0 未确认 1 已确认】
 * @author ChenYuanRong
 * @date 2017年8月5日 上午9:37:42
 * @version 1.0
 */
public enum EnumConfirmFlag {
	/**
	 * 未确认
	 */
	WQR (0),
	/**
	 * 已确认
	 */
	YQR(1);
	
	private final int value;
	 EnumConfirmFlag (int val)
	{
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
					text = "未确认";
					break;
				case 1:
					text = "已确认";
					break;
			}
			return text;
		} 
		
	 /**
	 * 获取value值
	 * @author ChenYuanRong
	 * @date 2017年8月5日 上午9:37:42
	 * @return
	 */
		public int getValue() {
			return this.value;
		}

		/**
		 * 通过值获取枚举
		 * @author ChenYuanRong
		 * @date 2017年8月5日 上午9:37:42
		 * @param value
		 * @return
		 */
		public EnumConfirmFlag get(int value) {
			for (EnumConfirmFlag item : values()) {
				if (item.value == value) {
					return item;
				}
			}
			return null;
		}
}
