package com.example.demo;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.ShiroMapper;
import com.example.demo.entity.ShiroUser;
import com.example.demo.service.ShiroService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ShiroApplicationTests {
	@Autowired
	ShiroMapper shiroMapper;
	@Autowired
	ShiroService shiroService;

	//插入一条数据
	//@Test
	void a() {
		ShiroUser shiroUser=ShiroUser.builder()
				.id(6L)
				.username("6")
				.password("6")
				.salt("6")
				.nickname("6")
				.phone("6")
				.email("6")
				.birthday(6L)
				.sex(6L)
				.status(1L)
				.createtime(6L)
				.updatetime(6L)
				.build();
	    shiroMapper.insert(shiroUser);
	}


	void b(){
	   int b= shiroMapper.deleteById(6L);
	   log.info("{}",b);
	}

	//@Test
	void c(){
        QueryWrapper<ShiroUser> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username","5");
        shiroMapper.delete(queryWrapper);
    }

    @Test
    void d(){
		ShiroUser shiroUser=shiroService.selectShiroUser("1");
	}


}
