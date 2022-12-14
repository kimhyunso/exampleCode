package chapter07;

public class InstanceOfEx {

    public static void method1(Parent parent){
        if(parent instanceof Child){
            Child child = (Child) parent;
            System.out.println("method1 - Child 변환 성공");
        }else
            System.out.println("method2 - Child 변환되지 않음");
    }

    public static void method2(Parent parent){
        Child child = (Child) parent;
        System.out.println("method1 - Child로 변환 성공");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        //parent 객체가 child를 가리키고 있어 변환이 성공한다.
        method1(parent);
        method2(parent);

        Parent parent1 = new Parent();
        //parent 객체가 parent 자신을 가리고 있어 변환이 실패한다.
        method1(parent1);
        //method2(parent1); 사용불가 parent 객체를 강제로 타입캐스팅하려고 하고 있음
    }
}
