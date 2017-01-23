package cn.myblog.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DocumentHandler {
	// 创建freemarker配置对象
	private Configuration configuration = null;

	/**
	 * 创建时加载文档配置
	 */
	public DocumentHandler() {
		this.configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDefaultEncoding("utf-8");
	}

	public void createDoc(Map<String, Object> dataMap, String fileName) {
		/**
		 * dataMap用于装入数据文件 设置模板方法和路径
		 */
		configuration.setClassForTemplateLoading(this.getClass(), "/temp");
		Template template = null;
		try {
			// 装载模板
			template = configuration.getTemplate("JZGZLXD.ftl");
		} catch (IOException e) {
			e.printStackTrace();
		}

		File outFile = new File(fileName);
		Writer writer = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outFile);
			// 确保解析时编码不会报错
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			writer = new BufferedWriter(osw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			template.process(dataMap, writer);
			fos.close();
			writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
