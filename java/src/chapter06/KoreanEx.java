package chapter06;

public class KoreanEx {
    public static void main(String[] args) {
        Korean k1 = new Korean("박자바","011225-1234567");
        System.out.println("k1.name : "+k1.name+"\n"+"k1.ssn : "+k1.ssn);

        Korean k2 = new Korean("김자바","930525-1234567");
        System.out.println("k2.name : "+k2.name+"\n"+"k2.ssn : "+k2.ssn);

    }
}
