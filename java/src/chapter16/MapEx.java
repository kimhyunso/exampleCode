package chapter16;

import java.util.Arrays;
import java.util.List;

public class MapEx {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student("홍길동",10),
            new Student("신용권",20),
            new Student("유미선",30)
        );

        list.stream()
                .mapToInt(Student :: getScore)
                .forEach(System.out :: println);
    }
}
