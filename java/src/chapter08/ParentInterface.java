package chapter08;

public interface ParentInterface {
    public abstract void method1();
    public default void method2(){
        /*실행문*/
    }
}
