package chapter07;

public class ChildEx {
    public static void main(String[] args) {
        /*Child child = new Child();

        Parent parent = child;
        parent.method1();
        //재정의된 메소드(오버라이딩)가 호출됨
        parent.method2();
        */

        Parent parent = new Child();

        parent.field = "data1";

        parent.method1();
        //오버라이딩
        parent.method2();

        Child child = (Child) parent;
        child.field2 = "yyy";
        child.method3();
    }

}
