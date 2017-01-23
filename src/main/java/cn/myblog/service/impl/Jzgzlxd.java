package cn.myblog.service.impl;

import java.util.HashMap;
import java.util.Map;

import cn.myblog.utils.DocumentHandler;

public class Jzgzlxd {
	public void exportgzlxd() {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("", "");
	
	}
	
	public static void main(String[] args) {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("zhi", "南京信息技术有限公司");
		String xxlr ="在Oracle 10g中MERGE有如下一些改进：/r/n1、UPDATE或INSERT子句是可选的/r/n 2、UPDATE和INSERT子句可以加WHERE子句 /r/n 3、在ON条件中使用常量过滤谓词来insert所有的行到目标表中,不需要连接源表和目标表/r/n 4、UPDATE子句后面可以跟DELETE子句来去除一些不需要的行/r/n "; 
		map.put("xxlr", xxlr);
		map.put("gysmc", "南京江宁技术有限公司");
		map.put("gyslxr", "江宁");
		map.put("gyslxfs", "15623458794");
		map.put("jlrq", "2017-01-10");
		map.put("clyj", "该问题可经由省公司协调处理");
		map.put("jzdwmc", "河北技术有限公司");
		map.put("jzdwlxr", "何月");
		map.put("jzdwlxfs", "18976541254");
		map.put("qrrq", "2017-01-19");

		dataMap.put("JZGZLXD", map);
		
		DocumentHandler dh = new DocumentHandler();
		dh.createDoc(dataMap, "D:/OUTPUT.docx");
	}
}
