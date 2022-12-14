package chapter16.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEx3 {
    public static void main(String[] args) {
        List<Member1> list = Arrays.asList(
                new Member1("홍길동","개발자"),
                new Member1("김나리","디자이너"),
                new Member1("신용권","개발자")
        );

        Map<String,List<String>> groupingMap = list.stream()
                .collect(
                        Collectors.groupingBy(
                                Member1 :: getJob,
                                Collectors.mapping(Member1::getName ,Collectors.toList())
                        )
                );
        System.out.println("[개발자]");
        groupingMap.get("개발자").stream().forEach(System.out::println);

        System.out.println("[디자이너]");
        groupingMap.get("디자이너").stream().forEach(System.out::println);
    }
}
