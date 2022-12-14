package chapter16.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx2 {
    public static void main(String[] args) {
        List<Member1> list = Arrays.asList(
                new Member1("홍길동","개발자"),
                new Member1("김나리","디자이너"),
                new Member1("신용권","개발자")
        );

       List<Member1> developers = list.stream()
               .filter(s->s.getJob().equals("개발자"))
               .collect(Collectors.toList());

      developers.stream().forEach(s -> System.out.println(s.getName()));
    }
}
