package chapter11.example;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrintEx {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 E요일 dd일 hh시 mm분");
        System.out.println(sdf.format(now));
    }

}
