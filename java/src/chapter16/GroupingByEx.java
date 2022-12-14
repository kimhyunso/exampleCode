package chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByEx {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동",10,Student.Gender.MALE,Student.City.Seoul),
                new Student("김수애",6,Student.Gender.FEMALE,Student.City.Pusan),
                new Student("신용권",10,Student.Gender.MALE,Student.City.Pusan),
                new Student("박수미",6,Student.Gender.FEMALE,Student.City.Seoul)
        );

        Map<Student.Gender, List<Student>> mapByGender = list.stream()
                .collect(Collectors.groupingBy(Student :: getGender));

        System.out.println("[남학생] ");
        mapByGender.get(Student.Gender.MALE).stream()
                .forEach(s->System.out.println(s.getName()));

        System.out.println("[여학생]");
        mapByGender.get(Student.Gender.FEMALE).stream()
                .forEach(s->System.out.println(s.getName()));

        System.out.println();

        Map<Student.City, List<String>> mapByCity = list.stream()
                .collect(Collectors.groupingBy(
                        Student::getCity,
                        Collectors.mapping(Student::getName, Collectors.toList())
                ));

        System.out.println("[서울]");
        mapByCity.get(Student.City.Seoul).stream()
                .forEach(System.out :: println);

        System.out.println("[부산]");
        mapByCity.get(Student.City.Pusan).stream()
                .forEach(System.out :: println);
    }
}
