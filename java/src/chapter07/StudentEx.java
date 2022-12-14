package chapter07;

public class StudentEx {
    public static void main(String[] args) {
        Student student = new Student("홍길동","123456-78912",1);
        System.out.println("name : "+student.name);
        System.out.println("ssn : "+student.ssn);
        System.out.println("studentNo : "+student.studentNO);
    }


}
