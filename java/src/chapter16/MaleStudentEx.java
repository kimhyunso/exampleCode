package chapter16;

import chapter11.SystemTimeEx;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaleStudentEx {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동",10,Student.Gender.MALE),
                new Student("김수애",6,Student.Gender.FEMALE),
                new Student("신용권",10,Student.Gender.MALE),
                new Student("박수미",6,Student.Gender.FEMALE)
        );

        /*MaleStudent maleStudent = list.stream()
                .filter(s -> s.getGender().equals(Student.Gender.MALE))
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

        maleStudent.getList().stream()
                .forEach(s->System.out.println(s.getName()));*/



        MaleStudent maleStudent1 = list.parallelStream()
                .filter(s->s.getGender().equals(Student.Gender.MALE))
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);
        maleStudent1.getList().stream()
                .forEach(s-> System.out.println(s.getName()));
    }
}
