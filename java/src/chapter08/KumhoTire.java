package chapter08;

public class KumhoTire implements Tire{

    @Override
    public void roll(String name) {
        System.out.println(name);
        System.out.println("금호 타이어가 굴러갑니다.");
    }
}
