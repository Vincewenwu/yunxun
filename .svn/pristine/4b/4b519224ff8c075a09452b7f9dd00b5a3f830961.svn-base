package com.vision.edu.common.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xiaoleilu.hutool.util.RandomUtil;

/**
 * 单号生成工具
 * @author zhangfeihong
 * @date 2017年8月9日 下午5:33:06
 * @version 1.0
 */
public class OrderUtil {
	public static void main(String[] args) {
		OrderUtil.getOrderNum();
	}

	/**
	 * 生成订单
	 * @author zhangfeihong
	 * @date 2017年8月9日 下午8:04:00
	 * @return
	 */
	public static String getOrderNum() {
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssSS");
		String date = format.format(new Date());
		String random = RandomUtil.randomNumbers(2);
		return date + random;
	}
}
