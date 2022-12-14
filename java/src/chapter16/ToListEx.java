package chapter16;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ToListEx {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동",10,Student.Gender.MALE),
                new Student("김이나",6,Student.Gender.FEMALE),
                new Student("박수미",6,Student.Gender.FEMALE),
                new Student("신용권",10,Student.Gender.MALE)
        );

        List<Student> maleList = list.stream()
                .filter(s -> s.getGender().equals(Student.Gender.MALE))
                .collect(Collectors.toList());
        maleList.stream().forEach(s->System.out.println(s.getName()));

        System.out.println();

        Set<Student> femaleSet = list.stream()
                .filter(s -> s.getGender().equals(Student.Gender.FEMALE))
                .collect(Collectors.toSet());
        femaleSet.stream().forEach(s->System.out.println(s.getName()));
    }
}
