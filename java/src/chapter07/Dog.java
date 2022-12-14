package chapter07;

public class Dog extends Animal{
    public Dog(){
        setKind("포유류");
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
