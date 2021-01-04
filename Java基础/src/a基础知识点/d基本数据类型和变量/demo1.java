package a基础知识点.d基本数据类型和变量;

public class demo1 {


    public static void main(String[] args) {
        /**
         * Java使用16位的Unicode码
         * ASCII码：一个字节(16进制数)表示一个字符
         * Unicode(UTF-8、UTF-16编码方式)两个字节(16进制数)表示一个字符
         * Ox开头代表16进制数
         * 反斜杠u代表unicode编码，是一个字符
         */

        /**
         * byte short int long
         * float double
         * boolean
         * char
         * 基本数据类型不需要开辟内存
         *
         * 数据类型   大小       范围                                  默认值
         * byte    1字节8bit   -128~127                                 0
         * short   2字节16bit  -3_2768~3_2767                           0
         * int     4字节32bit -21_4748_3648~21_4748_3647(超过20亿)       0
         * long    8字节64bit -...~+....                                0L/l
         * float   4字节32bit -...~=...                                 0.0f/F
         * double  8字节64位  -...~=...                                 0.0d/D
         * boolean ------     true or false                             false
         * char    2字节16位   0~65535                                  '\u0000'
         *
         */
        /**
         * 整型byte short int long
         * 没有后缀的整型字面值常量默认值int类型
         *
         * JDK7开始，数字字面值可以加下划线_，java编译器会去除下划线。
         * JDK7开始，加前缀0B/0b可以写二进制数
         */
        int int1=1_000_000;
        System.out.println(int1);//1000000
        int int2=0b1001;
        System.out.println(int2);//9
        long long1=3L;
        long long2=3;

        int max=Integer.MAX_VALUE;
        System.out.println(max);
        // max+1=min数据溢出
        System.out.println(max+1);
        int min=Integer.MIN_VALUE;
        System.out.println(min);
        //min-1=max
        System.out.println(min-1);


        /**
         * 浮点型float double
         * float类型的数，加后缀f/F,不加会报错
         * double类型的数，可加可不加后缀d/D
         *
         * 没有后缀的浮点型字面值常量默认是double类型。
         */
        //float float1=3.0;
        double double1=3.0;
        double double2=30.3d;


        /**
         * 布尔型boolean
         */

        /**
         * 字符型char 用于表示Unicode码
         * char类型字面值用单引号'',用双引号""会报错
         */
        char char1='\u0041';
        //char char2="\u0041";





        /**
         * 整型变量默认值是int类型
         * 浮点型变量默认值是double类型
         *基本数据类型转换：自动类型转换（隐式类型转换）和强制类型转换（显示类型转换)
         *
         * 自动类型转换：byte->short(char)->int->long->float->double
         * 范围小的和范围大的数据操作，范围小的自动变为范围大的数据类型
         *
         * double->float->long->int->short(char)->byte
         * 范围大的数据变成范围小的数据，需要强制转换。丢失精度。
         *
         */
          //字面值常量是int型，但在byte类型的范围内，jvm会自动将int型转化为byte型
          byte a=127;
          //超过byte范围报错
          //byte b=128;
          //
          char c1=65535;
          //超过范围
         //char c2=65536;
         short s1=32767;
         //超过范围
         //short s2=32768;


        int y1=3; //编译器确认
        //byte y2=y1; //报错 运行期确认

        /**
         * 算术运算的基本类型转换
         * 先转换成范围大的数据类型，在参加运算。
         * byte short char参加运算自动转换成int
         */





        /**
         * 字面值常量只能是
         * 整数  2 不加后缀默认int
         * 小数  2.3 不加后缀默认double
         * 长整型整数 2l  加后缀就是长整型
         *  float类型的小数  2.0f  加后缀就是float类型
         *  double类型的小数 2.0d  加后缀就是double类型
         */



        /**
         * 所有变量在使用前要赋予默认值，否则编译错误。
         */
        int x;
        //System.out.println(x);






















    }

}
