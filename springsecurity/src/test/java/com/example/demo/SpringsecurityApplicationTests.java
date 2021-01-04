package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sound.midi.SysexMessage;

@SpringBootTest
class SpringsecurityApplicationTests {

	@Test
	void contextLoads() {
		PasswordEncoder pe=new BCryptPasswordEncoder();
		//加密
		String s=pe.encode("123456");
		System.out.println(s);
		//是否匹配密码
		boolean b=pe.matches("123456",s);
		System.out.println(b);
	}

}
