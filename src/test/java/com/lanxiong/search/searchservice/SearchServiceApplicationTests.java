package com.lanxiong.search.searchservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceApplicationTests {


	@Test
	public void contextLoads() {
	}

	@Test
	public void loggerTest(){
		log.info("info...........");
//		log.debug("debug...........");
//		log.error("err...........");
//		log.warn("warn...........");
	}

}
