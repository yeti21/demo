package s时间类;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        String s= simpleDateFormat.format(date);
        System.out.println(s);

        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
        String s1= simpleDateFormat1.format(date);
        System.out.println(s1);

    }
}
