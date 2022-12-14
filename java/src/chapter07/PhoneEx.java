package chapter07;

public class PhoneEx {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone("홍길동");

        //추상클래스(Phone)의 메소드
        phone.turnOn();
        //실제 클래스(SmartPhone)의 메소드
        phone.internetSearch();
        //추상클래스(Phone)의 메소드
        phone.turnOff();
    }

}
