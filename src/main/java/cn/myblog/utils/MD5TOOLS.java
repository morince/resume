package cn.myblog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class MD5TOOLS {
	/**
	 * 获取md5值
	 * @param src
	 * @return
	 */
	public static String getMD5(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(src.getBytes());
			return new String(Hex.encodeHex(digest));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
