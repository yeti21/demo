package 代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//柜台A
public class GuitaiA implements InvocationHandler {

    private Object pingpai;

    public GuitaiA(Object pingpai){
        this.pingpai=pingpai;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("销售开始，柜台是："+this.getClass().getSimpleName());
       method.invoke(pingpai,args);
       System.out.println("销售结束");
       return null;
        /**
         * public Object invoke(Object proxy, Method method, Object[] args)
         *         throws Throwable;
         * proxy 代理对象
         * method 代理对象调用的方法
         * args 调用的方法中的参数
         */
    }
}
