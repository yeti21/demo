package p多线程和并发.a;

public class A {
    public static void main(String[] args) {
        new Thread(new B()).start();
        new Thread(new C()).start();
    }

    static class B implements  Runnable {
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 1; i < 11; i++) {
                    System.out.println(i);
                }
            }
        }


    }

    static class C implements Runnable{

        @Override
        public void run() {
            synchronized (this){
                for(int i=0;i<10;i++){
                    System.out.print(Character.toUpperCase ((char)(97+i))+" ");
                }
            }
        }


    }












}
