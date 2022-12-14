package chapter07.example;

class A{}
class B extends A{}
class C extends A{}

class D extends B{}
class E extends B{}
class F extends C{}



public class PromotionEx {
    public static void main(String[] args) {
        //B b = (B)new A(); 부모 객체를 강제 타입 변환 시키고 있음

        A a = new B();
        B b = (B)a;
    }
}
