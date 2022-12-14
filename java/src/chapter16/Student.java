package chapter16;

public class Student implements Comparable<Student>{
    public enum Gender {MALE, FEMALE}
    public enum City{Seoul, Pusan}
    private String name;
    private int score;
    private Gender gender;
    private City city;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, Gender gender){
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public Student(String name, int score, Gender gender, City city){
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public City getCity() {
        return city;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score,o.getScore());
    }
}
