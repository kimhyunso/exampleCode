package chapter08;

public class HankooTire implements Tire{

    @Override
    public void roll(String name) {
        System.out.println(name);
        System.out.println("한국 타이어가 굴러갑니다.");
    }
}
