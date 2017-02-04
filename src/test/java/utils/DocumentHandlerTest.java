package utils;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import cn.myblog.dao.ResumeDao;
import cn.myblog.entity.CommonCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:*/spring-web.xml", "classpath*:*/spring-dao.xml",
		"classpath*:*/spring-mybatis.xml", "classpath*:*/spring-service.xml", "classpath*:*/UserForWeb.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class DocumentHandlerTest {
	@Autowired
	private ResumeDao dao;

	@Test
	public void test() {
		String seq = Integer.toString(dao.getResumeSeq(CommonCode.resumeSeq));
		StringBuffer appendZero = new StringBuffer();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		appendZero.append(sdf.format(date));
		if (seq.length() > 5) {
			dao.resetSeq(CommonCode.resumeSeq);
			seq = Integer.toString(dao.getResumeSeq(CommonCode.resumeSeq));
		}
		
		for (int i = 0; i < 5 - seq.length(); i++) {
			appendZero.append("0");
		}

		appendZero.append(seq);
		System.out.println(appendZero.toString());

	}
}
