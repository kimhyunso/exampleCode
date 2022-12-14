package chapter11;

import java.util.regex.Pattern;

public class PatternEx {
    public static void main(String[] args) {
        String regExp = "(02|01\\d)-\\d{3,4}-\\d{4}";
        String data = "011-5531-7332";
        boolean result = Pattern.matches(regExp,data);
        if(result)
            System.out.println("정규식과 일치합니다.");
        else
            System.out.println("정규식과 일치하지 않습니다.");

        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "angel@naver.co.kr";

        result = Pattern.matches(regExp,data);
        if(result)
            System.out.println("정규식과 일치합니다.");
        else
            System.out.println("정규식과 일치하지 않습니다.");

    }

}
