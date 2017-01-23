package cn.myblog.utils;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AESUtil {
	Log log = LogFactory.getLog(AESUtil.class);

	/**
	 * 向量IV值
	 */
	private static final String iv_value = "0000000011111111";

	/**
	 * 构造器
	 */
	public AESUtil() {

	}

	public String encrypt(String src, String key) throws Exception {
		if (key == null) {
			log.warn("key值为空");
			return null;
		}

		byte[] raw = key.getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(raw, "AEC");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//算法/模式/补码方式
		IvParameterSpec iv = new IvParameterSpec(iv_value.getBytes());
		return "";
	}
}
