package 代理模式.静态代理;

public class ProxyTest {
    public static void main(String[] args) {
        Real real=new Real();
        Movie movie=new Proxy(real);
        movie.play();
        /**
         * 静态代理：
         * 可以在不修改被代理对象（目标对象）的基础上，通过扩展代理类，
         * 进行一些功能的附加与增强。
         * 值得注意的是，代理类和被代理类应该共同实现一个接口，或者是共同继承某个类。
         */
    }

}
