package chapter16;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayEx {
    public static void main(String[] args) {
        String[] strArray = {"홍길동","신용권","김미나"};
        Stream<String> strStream = Arrays.stream(strArray);
        strStream.forEach(s->System.out.print(s+","));

        int intArray[] = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(intArray);
        intStream.forEach(s->System.out.print(s+","));
    }
}
