package chapter16;

import java.util.Arrays;
import java.util.List;

public class StreamPipelineEx {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
            new Member("홍길동",Member.MALE,30),
            new Member("김나리",Member.FEMALE,20),
            new Member("김자바",Member.MALE,45),
            new Member("박수미",Member.FEMALE,27)
        );
        double ageAvg = list.stream()
                .filter(m -> m.getGender() == Member.MALE)
                .mapToInt(Member :: getAge)
                .average()
                .getAsDouble();

        System.out.println("남자 평균 나이: "+ageAvg);
    }
}
