package com.vision.edu.framework.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import com.vision.edu.platform.util.StringUtil;
import com.xiaoleilu.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.xiaoleilu.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * 加密解密工具类
 * @author XieFan
 * @date 2017年7月16日 上午10:11:56
 * @version 1.0
 */
public class EncryptUtil {
	
	/**
	 * 加密
	 * @author XieFan
	 * @date 2017年7月16日 上午10:12:21
	 * @param content 加密内容
	 * @param pass 加密密钥
	 * @return
	 */
	public static String encrypt(String content,String pass){
		if(StringUtil.isEmpty(content)){
			return null;
		}
		if(StringUtil.isEmpty(pass)){
			return null;
		}
		try {
			KeyGenerator kg = KeyGenerator.getInstance(SymmetricAlgorithm.AES.getValue());
			kg.init(128, new SecureRandom(pass.getBytes()));
			SecretKey sk = kg.generateKey();
			byte[] key = sk.getEncoded();
			SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
			String encryptHex = aes.encryptHex(content);
			return encryptHex;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 解密
	 * @author XieFan
	 * @date 2017年7月16日 上午10:12:55
	 * @param content 解密内容
	 * @param pass 解密密钥
	 * @return
	 */
	public static String decrypt(String content,String pass){
		if(StringUtil.isEmpty(content)){
			return null;
		}
		if(StringUtil.isEmpty(pass)){
			return null;
		}
		try {
			KeyGenerator kg = KeyGenerator.getInstance(SymmetricAlgorithm.AES.getValue());
			kg.init(128, new SecureRandom(pass.getBytes()));
			SecretKey sk = kg.generateKey();
			byte[] key = sk.getEncoded();
			SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
			String decryptStr = aes.decryptStr(content);
			return decryptStr;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String str = "123456";
		String key = "xiefan";
		String mima = EncryptUtil.encrypt(str, key);
		String jiemi = EncryptUtil.decrypt(mima, key);
		System.out.println(UUID.randomUUID().toString().replace("-", ""));
		System.out.println("加密前：" + str);
		System.out.println("加密后：" + mima);
		System.out.println("解密后：" + jiemi);
	}
	
}
