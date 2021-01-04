package com.example.demo.controller;

import com.example.demo.entity.A;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
*访问地址：http://localhost:8080/demo/swagger-ui.html
* */
@RestController
@Api(value = "类描述")
public class SwaggerController {

    @GetMapping("/swagger1")
    @ApiOperation(value = "方法描述")
    @ApiImplicitParam(value = "单个参数描述")
    public String a1( @RequestParam("name") String name){
        return name;
    }

    @GetMapping("/swagger2")
    @ApiImplicitParams({@ApiImplicitParam(value = "多个参数"),@ApiImplicitParam(value = "多个参数")})
    public A a2(@RequestParam("name")String name, @RequestParam("age") Integer age){
        return new A(name,age);
    }


}
