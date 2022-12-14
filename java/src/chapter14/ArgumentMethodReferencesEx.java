package chapter14;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesEx {
    public static void main(String[] args) {
        ToIntBiFunction<String, String> function;

        function = (a,b) -> a.compareToIgnoreCase(b);
        printf(function.applyAsInt("Java8","JAVA8"));

        function  = String :: compareToIgnoreCase;
        printf(function.applyAsInt("Java8","JAVA8"));
    }

    public static void printf(int order){
        if (order<0) System.out.println("사전순으로 먼저 옵니다.");
        else if (order == 0) System.out.println("동일한 문자입니다.");
        else System.out.println("사전순으로 나중에 옵니다.");
    }
}
