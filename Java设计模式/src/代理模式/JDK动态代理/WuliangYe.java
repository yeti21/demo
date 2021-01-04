package 代理模式.JDK动态代理;

public class WuliangYe implements SellWine{
    @Override
    public void jiu() {
        System.out.println("我卖的是五粮液");
    }
}
