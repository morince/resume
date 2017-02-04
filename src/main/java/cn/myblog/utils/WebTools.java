package cn.myblog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import cn.myblog.dao.UserDao;
import cn.myblog.entity.CommonCode;

public class WebTools {

	/**
	 * 通过request拼接json字符串后再转为json对象
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getJsonFromRequest(HttpServletRequest request) throws Exception {
		Map<String, String[]> map = request.getParameterMap();
		if(map.isEmpty()){
			System.out.println("值为空");
			return null;
			
		}
		StringBuffer temp = new StringBuffer();
		for (Entry<String, String[]> entry : map.entrySet()) {
			temp.append(entry.getKey());
		}
		return new JSONObject(temp.toString());
	}
	// public static JSONObject getJsonFromRequest(HttpServletRequest request)
	// throws Exception {
	// BufferedReader reader = request.getReader();
	// String line = "";
	// String body = "";
	// while ((line = reader.readLine()) != null) {
	// body += line;
	// }
	// if ("".equals(body)) {
	// body = "{}";
	// }
	// return new JSONObject(reader);
	// }

	/**
	 * 获取uuid = uuid+年月日
	 * @return
	 */
	public static String getUUID() {
		StringBuffer uuid = new StringBuffer();
		uuid.append(UUID.randomUUID().toString());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		uuid.append(sdf.format(date.getTime()));
		return uuid.toString();
	}

	

}
