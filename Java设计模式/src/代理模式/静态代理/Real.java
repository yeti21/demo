package 代理模式.静态代理;

public class Real implements Movie{
    @Override
    public void play() {
        System.out.println("你正在看电影《功夫》");
    }
}
