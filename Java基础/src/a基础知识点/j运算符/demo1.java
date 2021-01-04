package a基础知识点.j运算符;

import java.math.BigDecimal;

public class demo1 {

    public static void main(String[] args) {




    /**
     * 运算符的优先级
     */

    /**
     * 赋值运算符
     * =
     */

    /**
     * 算术运算符
     * + - * / %
     * 整型除法直接砍掉小数
     * 浮点数有精度问题，用math包解决
     */
    //整型测试
        System.out.println(10/4);
    //浮点型测试
        BigDecimal bigDecimal=new BigDecimal(15.6);

    A a1=new A();
    A a2=new A();
    // a1+a2; 对象不能运算



        /**
         * 递增和递减
         * ++ --
         * 前递增 ++a   先递增后返回值
         * 后递增 a++   先返回值，后递增
         * 前递减 --a
         * 后递减 a--
         */
         int i=1;
         System.out.println("++i="+ ++i);//2
         System.out.println("i++="+ i++);//2
         System.out.println("i="+i);//3
        System.out.println("--i="+ --i);//2
        System.out.println("i--="+ i--);//2
        System.out.println("i="+i);//1


        /**
         * 关系运算符
         * >  <  >=  <=  ==  !=
         *
         */

        /**
         * 逻辑运算符
         * &&  ||  ！
         * 短路问题
         */

        /**
         * 位运算符
         * & |  ^（异或） ~()
         */

        /**
         * 位移运算符
         * <<  >>
         */

        /**
         * 三元运算符
         * ?
         */

        /**
         * 字符串运算符
         * + +=唯一的两个可以重载的运算符
         */





    }

}
