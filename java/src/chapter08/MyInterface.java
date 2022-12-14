package chapter08;

public interface MyInterface {
    public abstract void method1();

    //MyInterface를 상속받은 MyClass는 에러를 발생하지 않는다.
    public default void method2(){
        System.out.println("MyInterface-method2 실행");
    }
}
