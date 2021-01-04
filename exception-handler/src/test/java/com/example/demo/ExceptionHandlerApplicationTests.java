package com.example.demo;

import com.example.demo.constant.Status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExceptionHandlerApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(Status.OK.getCode());
		System.out.println(Status.OK.getMeggage());

	}

}
