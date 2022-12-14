package chapter15.example;

import java.util.Objects;

public class Student {
    public int studentNum;
    public String name;

    public Student(int studentNum, String name){
        this.name = name;
        this.studentNum = studentNum;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Student){
            Student student = (Student) o;
            if(student.studentNum == studentNum)
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return studentNum;
    }
}
