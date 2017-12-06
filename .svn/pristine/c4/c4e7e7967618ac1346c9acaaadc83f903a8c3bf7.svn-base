package com.vision.edu.framework.util;

import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

/**
 * 绑定码
 * @author jiangwangying
 * @date 2017年7月31日 上午8:56:40
 * @version 1.0
 */
public class BindingCodeUtil {

    public static String huoqu6weishu(){
    	String bingdingCode = "";
    	bingdingCode = random(6);
   	    if (!bingdingCode.equals("")) {
			return bingdingCode;
		} else {
			huoqu6weishu();
		}
   	    return bingdingCode;
    }
	 public static String random(int length){//传入的字符串的长度
	        StringBuilder builder = new StringBuilder(length);
	        for(int i = 0; i < length; i++){
	            
	            int r = (int) (Math.random()*3);
	            int rn1=(int)(48+Math.random()*10);
	            int rn2=(int)(65+Math.random()*26);
	            int rn3=(int)(97+Math.random()*26);
	            
	            switch(r){
	            case 0:   
	                builder.append((char)rn1);
	                break;
	            case 1:
	                builder.append((char)rn2);
	                break;
	            case 2:
	                builder.append((char)rn3);
	                break;
	            }
	        }
	        return builder.toString();
	  }
}
