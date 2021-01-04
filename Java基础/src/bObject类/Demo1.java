package bObject类;

public class Demo1 {
    public static void main(String[] args) {
        /**
         *  Object类是所有对象的父类（包括数组），所有对象都实现了这类的方法。
         *  hashCode()
         *  equals()
         *  getClass()
         *  toString()
         *  clone()
         *
         *  wait()
         *  wait(long timeout)
         *  wait(long timeout,int nanos)
         *  notify()
         *  notifyAll()
         *  finalize()
         */

        /**
         * 同一个对象哈希值一定相同，哈希值相同不一定是同一个对象。
         * 重写equals方法时，应该总是重写hashCode方法，保证哈希值相同。
         */
        Object object1=new Object();
        Object object2=new Object();
        System.out.println("object1的哈希值="+object1.hashCode());
        System.out.println("object2的哈希值="+object2.hashCode());

        /**
         * ==和equals的区别
         * 对于基本数据类型而言，==判断值是否相等，基本数据类型没有equals
         * 对于引用数据类型而言，==判断是否是同一个对象，Object类的equals方法和==相同。
         * 而其他类会重写equals方法，用于判断值是否相等
         */
        System.out.println(object1.equals(object2));

        /**
         * Object类的toString方法，
         * @后面是哈希值的无符号16进制表示。
         */
        System.out.println(object1.toString());

        Demo1 demo1=new Demo1();


    }
}
