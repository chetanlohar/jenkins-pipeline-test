package io.brainstorm.jenkinspipelinetest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsPipelineTestApplicationTests {

	@Autowired
	TestService service;

	@Test
	public void testAdd(){
		Assert.assertEquals(Integer.valueOf(5),service.add(2,3));
	}

}
