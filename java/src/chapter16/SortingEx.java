package chapter16;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingEx {
    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[]{5,3,2,1,4});
        intStream
                .sorted()
                .forEach(System.out :: println);
        System.out.println();

        List<Student> list = Arrays.asList(
                new Student("홍길동",30),
                new Student("김자바",10),
                new Student("유미선",20)
        );
        list.stream()
                .sorted()
                .forEach(s->System.out.println(s.getScore()));
        System.out.println();
        
        //내림차순 정렬
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(s->System.out.println(s.getScore()));
    }
}
