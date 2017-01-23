package utils;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

@RunWith(BlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-web.xml", "classpath:spring-dao.xml",
		"classpath:spring-mybatis.xml", "classpath:spring-service.xml" })
public class DocumentHandlerTest {

}
