package com.example.demo;

import com.example.demo.Service.UserService;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class EhcacheApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void a() {
		User user1=userService.get(1L);
		log.info("{}",user1);

		User user2=userService.get(1L);
		log.info("{}",user2);

	}

	void b(){

	}

	void c(){

	}

}
