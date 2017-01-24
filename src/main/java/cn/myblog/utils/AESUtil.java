package cn.myblog.utils;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AESUtil {
	static Log log = LogFactory.getLog(AESUtil.class);

	/**
	 * 向量IV值
	 */
	private static final String KEY = "MYRESUMEEMUSERYM";
	/**
	 * 向量IV值
	 */
	private static final String iv_value = "2000000010000000";

	/**
	 * 构造器
	 */
	public AESUtil() {

	}

	/**
	 * 密码加密方法
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String src, String key) throws Exception {
		if (key == null) {
			log.warn("key值为空");
			return null;
		}

		byte[] raw = key.getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
		//算法/模式/补码方式
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		// 使用CBC模式，需要一个向量iv，可增加加密算法的强度 
		IvParameterSpec iv = new IvParameterSpec(iv_value.getBytes());
		//初始化
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
		//第一次加密
		byte[] encrypt = cipher.doFinal(src.getBytes());
		String encrptString = Base64.getEncoder().encodeToString(encrypt);
		
		//第二次加密（编码）
		return encrptString;
	}
	
	/**
	 * 密码解密方法
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String src, String key) throws Exception {
		if (key == null) {
			log.warn("key值为空");
			return null;
		}

		byte[] raw = key.getBytes("ASCII");
		SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
		//算法/模式/补码方式
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		// 使用CBC模式，需要一个向量iv，可增加加密算法的强度 
		IvParameterSpec iv = new IvParameterSpec(iv_value.getBytes());
		//初始化
		cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
		byte[] decrypt = Base64.getDecoder().decode(src.getBytes());
		byte[] origin = cipher.doFinal(decrypt);
		String originSrc = new String(origin,"utf-8");
		return originSrc;
	}
	
	public static boolean validate(String psd){
		try {
			String psw = new String(psd.getBytes("GBK"),"utf-8");
			String origin = decrypt(psw,KEY);
			String[] pwd = origin.split(",");
			String md5 = MD5TOOLS.getMD5(pwd[1].toString());
			if(!pwd[0].toString().equals(md5)){
				return false;
			}
			
			return true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		try {
//			String a = encrypt("64A168EFE6B71EFA9A22566D599F8B54272FD5A86943014B77AD2B7F7F0F585CBE76CB43D9C049B2F1163BA37CDED78C",KEY);
			String b = decrypt("64A168EFE6B71EFA9A22566D599F8B54272FD5A86943014B77AD2B7F7F0F585CBE76CB43D9C049B2F1163BA37CDED78C", KEY);
			//System.out.println("加密后："+a);
			System.out.println("解密后："+b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
