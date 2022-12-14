package chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingAndReductionEx {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동",10,Student.Gender.MALE),
                new Student("김수애",12,Student.Gender.FEMALE),
                new Student("신용권",10,Student.Gender.MALE),
                new Student("박수미",12,Student.Gender.FEMALE)
        );

        Map<Student.Gender , Double> mapByGender = list.stream()
                .collect(
                        Collectors.groupingBy(
                                Student :: getGender,
                                Collectors.averagingDouble(Student :: getScore)
                        )
                );

        System.out.println("남학생 평균 점수 : "+mapByGender.get(Student.Gender.MALE));
        System.out.println("여학생 평균 점수 : "+mapByGender.get(Student.Gender.FEMALE));

        Map<Student.Gender, String> mapByName = list.stream()
                .collect(Collectors.groupingBy(
                        Student :: getGender,
                        Collectors.mapping(Student::getName,Collectors.joining(","))
                ));

        System.out.println("남학생 전체 이름 : "+mapByName.get(Student.Gender.MALE));
        System.out.println("여학생 전체 이름 : "+mapByName.get(Student.Gender.FEMALE));
    }
}
