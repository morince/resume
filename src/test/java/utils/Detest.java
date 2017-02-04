package utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import cn.myblog.entity.StaticEnum;
import cn.myblog.utils.DESCoder;

@RunWith(BlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-web.xml", "classpath:spring-dao.xml",
		"classpath:spring-mybatis.xml", "classpath:spring-service.xml" })
public class Detest {
	@Test
	public void test() throws Exception {
//		String inputStr = "12345678";
//		String a  = ESAPI.encoder().encodeForBase64(inputStr.getBytes(), false);
//		int options = 0;
//		options |= Base64.DONT_BREAK_LINES;
//		System.err.println(options);		
//		System.err.println(a);
		//   MTIzNDU2Nzg5NDY4NTQ4NjE1MTQ0NQ==
//		String inputStr = "1234567894685486151445";
//		String key = DESCoder.initKey();
//		System.err.println("原文:\t" + inputStr);
//
//		System.err.println("密钥:\t" + key);
//
//		byte[] inputData = inputStr.getBytes();
//		inputData = DESCoder.encrypt(inputData, key);
//
//		System.err.println("加密后:\t" + DESCoder.encryptBASE64(inputData));
//
//		byte[] outputData = DESCoder.decrypt(inputData, key);
//		String outputStr = new String(outputData);
//
//		System.err.println("解密后:\t" + outputStr);
//
//		assertEquals(inputStr, outputStr);
		int a  = StaticEnum.DELETE.getIndex();
	}
}
