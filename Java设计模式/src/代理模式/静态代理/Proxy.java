package 代理模式.静态代理;

public class Proxy implements Movie{

    Real real;
    public Proxy(Real real){
        super();
        this.real=real;
    }

    @Override
    public void play() {
        add(true);
        real.play();
        add(false);
    }

    public void add(boolean a){
        if(true){
            System.out.println("电影开始了，买点爆米花、可乐。");
        }else{
            System.out.println("电影结束啦，买点回家吃吧。");
        }
    }


}
