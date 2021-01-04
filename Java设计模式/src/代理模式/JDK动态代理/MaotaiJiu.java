package 代理模式.JDK动态代理;

public class MaotaiJiu implements SellWine{
    @Override
    public void jiu() {
        System.out.println("我卖的是茅台酒");
    }
}
