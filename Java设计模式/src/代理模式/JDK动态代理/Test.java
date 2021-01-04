package 代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        MaotaiJiu maotaiJiu=new MaotaiJiu();
        InvocationHandler invocationHandler=new GuitaiA(maotaiJiu);

       SellWine sellWine=(SellWine)Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
                MaotaiJiu.class.getInterfaces(),
                invocationHandler);
       sellWine.jiu();
        /**
         * static Object newProxyInstance(ClassLoader loader,
         *                                           Class<?>[] interfaces,
         *                                           InvocationHandler h)
         * loader：指定目标对象所使用的类加载器
         * interfaces：目标对象所实现接口的类型，使用泛型方式确认类型
         * h：事件处理，执行目标对象方式时，触发事件处理器的invoke方法,
         * 会把目标对象的方法和参数传入
          */
        WuliangYe wuliangYe=new WuliangYe();
        InvocationHandler invocationHandler1=new GuitaiA(wuliangYe);
        SellWine sellWine1=(SellWine)Proxy.newProxyInstance(WuliangYe.class.getClassLoader(),
                WuliangYe.class.getInterfaces(),
                invocationHandler1);
        sellWine1.jiu();

    }


}
