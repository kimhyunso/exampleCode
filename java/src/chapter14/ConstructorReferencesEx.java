package chapter14;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesEx {
    public static void main(String[] args) {
        Function<String, Member> function1 = Member :: new;
        Member member1 = function1.apply("angel");
        System.out.println("아이디: "+member1.getId());

        BiFunction<String, String, Member> function2 = Member :: new;
        Member member2 = function2.apply("신천사","angel");
        System.out.println("아이디: "+member2.getId()+" 이름: "+member2.getName());
    }
}
