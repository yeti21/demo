package com.example.demo;

import com.example.demo.方式一.DemoProperty;
import com.example.demo.方式二.Demo1Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertiesApplicationTests {

	@Autowired
	private DemoProperty demoProperty;

	@Autowired
	private Demo1Property demo1Property;

	@Test
	void contextLoads() {
		System.out.println(demoProperty.getPort());
		System.out.println(demo1Property.getPath());
	}

}
