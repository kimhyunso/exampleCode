package chapter16.example;

public class Member {
    private String name;
    private int age;
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
