package chapter11;

public class StringSubstringEx {
    public static void main(String[] args) {
        String ssn = "880815-1234567";

        String firstNum = ssn.substring(0,6); //0~6까지
        System.out.println(firstNum);
        String secondNum = ssn.substring(7); //7부터 끝까지
        System.out.println(secondNum);
    }
}
