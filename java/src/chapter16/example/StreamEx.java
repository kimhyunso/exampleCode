package chapter16.example;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class StreamEx {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "This is a java book",
                "Lambda Expressions",
                "Java8 supports lambda expressions"
        );

        list.stream()
                .filter(s->s.toLowerCase(Locale.ROOT).contains("java"))
                .forEach(System.out::println);
    }
}
