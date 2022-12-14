package chapter11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatEx {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
        String nowString = now.format(dtf);
        System.out.println(nowString);
    }

}
