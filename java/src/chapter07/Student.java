package chapter07;

public class Student extends People{
    public int studentNO;

    public Student(String name,String ssn, int studentNo){
        super(name,ssn);
        this.studentNO = studentNo;
    }
}
