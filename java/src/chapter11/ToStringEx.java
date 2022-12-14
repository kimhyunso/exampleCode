package chapter11;

import java.util.Date;
import java.util.Objects;

public class ToStringEx {
    public static void main(String[] args) {
        /*Object obj = new Object();
        Date obj2 = new Date();
        System.out.println(obj.toString());
        System.out.println(obj2.toString());*/

        String str1 = "홍길동";
        String str2 = null;

        System.out.println(Objects.toString(str1));
        System.out.println(Objects.toString(str2));
        System.out.println(Objects.toString(str2,"이름이 없습니다."));

    }
}
