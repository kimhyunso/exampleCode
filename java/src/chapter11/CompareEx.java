package chapter11;

import java.util.Objects;

public class CompareEx {
    public static void main(String[] args) {
        Student s1 = new Student(1);
        Student s2 = new Student(1);
        Student s3 = new Student(2);

        int result = Objects.compare(s1,s2,new StudentComparator());
        System.out.println(result);
        result = Objects.compare(s1,s3,new StudentComparator());
        System.out.println(result);
    }


    /*static class Student{
        int sno;
        public Student(int sno){
            this.sno = sno;
        }
    }*/
}
