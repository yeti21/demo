package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
Spring Boot 2.0现在默认使用CGLIB动态代理(基于类的动态代理), 包括AOP.
如果需要基于接口的动态代理(JDK基于接口的动态代理) , 需要设置spring.aop.proxy-target-class属性为false
 */

/*
使之成为切面类,实现controller层日志切面
 */
@Aspect
/*
把切面类加入到IOC容器中
 */
@Component
public class Aop {

   private static final Logger log=LoggerFactory.getLogger(Aop.class);

    /*
    定义切入点
    切入点为com.example.controller.restfulUserController下所有方法
     execution方法执行前触发
     public作用域
     *返回任意类型
    com.example.controller.restfulUserController切点所对应的方法所属的类
    .*(..)任意方法
     */
    //restfulUserController的切点
    @Pointcut(value = "execution(public * com.example.demo.controller.ThymeleafController.*(..))")
    public void  a() {
    }
    //restfulBookController的切点
    @Pointcut(value = "execution(public * com.example.demo.controller.ThymeleafController.*(..))")
    public  void b(){

    }

    /*
    前置通知：在连接点执行之前执行的通知,在目标方法被调用之前调用通知功能

    @Before("a()")
    public  void  doBeforeAdvice(){
       System.out.println("是否有权限");
    }*/

    /*
    后置通知: 在连接点执行之后执行的通知(返回通知和异常通知的异常),
    在目标方法完成之后调用通知，不关心方法的输出是什么

    @After("a()")
    public void  doAfterAdvice(){
        System.out.println("操作后的信息1");
    } */

    /*
    返回通知:在连接点执行之后执行的通知,在目标方法成功执行之后调用通知

    @AfterReturning("a()")
    public void doAfterReturningAdvice(){
        System.out.println("操作后的信息2");
    }  */

    /*
    异常通知:在连接点执行之后执行的通知,在目标方法抛出异常后调用通知

    @AfterThrowing("a()")
    public void doAfterThrowingAdvice(){
       System.out.println("操作错误");
    }*/


    /*
    环绕通知:通知包裹了被通知的方法，可同时定义前置通知和后置通知
    */
    @Around("a()")
     public  Object  doAroundAdvice(ProceedingJoinPoint pp) throws Throwable {
        Object object = null;
        try {
            log.debug("是否有权限");
            object=pp.proceed();
            log.info("操作成功");
        }catch (Throwable e){
            log.error("操作错误");
        }
        return object;
     }





}
