package chapter13;

import chapter06.package01.B;
import chapter09.A;

public class BoxEx {
    public static void main(String[] args) {
        /*Box box = new Box();
        //자동 타입 변환
        box.set("홍길동");
        //강제 타입변환
        String name = (String)box.get();

        //자동 타입변환
        box.set(new Apple());
        //강제 타입변환
        Apple apple = (Apple) box.get();*/

        Box<String> box = new Box<String>();
        box.set("홍길동");
        String name = box.get();

        Box<Apple> appleBox = new Box<Apple>();
        appleBox.set(new Apple());
        Apple apple = appleBox.get();
    }
}
