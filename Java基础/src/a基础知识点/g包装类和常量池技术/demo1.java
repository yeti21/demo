package a基础知识点.g包装类和常量池技术;

public class demo1 {
    public static void main(String[] args) {
        /**
         * 自动拆箱和自动装箱
         * 自动装箱：就是将基本数据类型转换为包装器类型
         * 自动拆箱：就是将包装器类型转换为基本数据类型
         */
        Byte byte1=1;
        byte byte2=byte1;

        //Byte byte3=128; //包装类变量的字面值常量只能是对应的基本类型范围内的值，不存在类型自动转换。否则报错



        /**
         *装箱和拆箱的实现
         *装箱的时候自动调用的是Integer的valueOf(int i)方法
         * static String valueOf(int i){} 静态方法
         *
         *在拆箱的时候自动调用的是Integer的intValue方法
         * int intValue(){}
         */

        Integer interger1=3;
        //相当于  Integer integer1=Integer.valueOf(3);
        int int1=interger1;
        /**
         * 相当于
         * Integer integer2=new Integer(3);
         *       int  = integer2.intValue();
         */


        /**
         * 常量池技术      池大小
         * Byte           [-128,127]
         * Short          [-128,127]
         * Integer        [-128,127]
         * Long           [-128,127]
         * Character      [0-127]
         * Boolean    直接返回true or false
         *
         * 超过池的大小，重新new一个对象
         */





    }
}
