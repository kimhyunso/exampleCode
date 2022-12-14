package chapter07;

public class Cat extends Animal{

    public Cat(){
        setKind("포유류");
    }

    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
