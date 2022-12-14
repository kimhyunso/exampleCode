package chapter08;

public interface ChildInterface2 extends ParentInterface {
    @Override
    default void method2() {
        /*재정의*/
    }
    public abstract void method3();
}
