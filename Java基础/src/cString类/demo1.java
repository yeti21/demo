package cString类;

public class demo1 {
    public static void main(String[] args) {
        /**
         *基本方法
         * length()获取字符串长度
         * charAt(int i)获得指定位置的指定字符，下表从0开始。
         * getChars()将字符串范围内的字符复制到字符数组中。
         *toString() 返回字符串本身
         *hashCode()返回哈希码
         */
        String s="优秀的人儿，我草你妈！";
        System.out.println("s字符串长度="+s.length());
        System.out.println(s.charAt(1));
        char[] c=new char[10];
        s.getChars(0,2,c,0);
        System.out.println(c);
        System.out.println(s.toString());
        System.out.println(s.hashCode());


        /**
         *字符串的比较
         *字符串常量池
         * equals()方法，判断字符串值是否相同。
         */
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2);//true
        System.out.println(s1.equals(s2));

        /**
         * 字符串转化成基本数据类型
         */
      byte byte1 = Byte.parseByte("10");
        System.out.println(byte1);
        int int1=Integer.parseInt("20");
        System.out.println(int1);
      boolean boolean1=Boolean.getBoolean("1");
      System.out.println(boolean1);



        /**
         * 基本数据类型转换成String
         * 1.String.valueOf()
         * 2.Byte.toString()
         */

        /**
         * 字符串查找
         * indexOf(int ch)
         * inexOf(String str)
         *
         */

        /**
         * 字符串截取和拆分
         *
         * subString()
         * split()
         */

        /**
         * 替换和修改
         * concat()合并字符串
         * replaceAll()需要正则表达式
         * replaceFirst()
         */











    }
}
