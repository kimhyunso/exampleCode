package chapter09;

public class A {

    int non_field;
    void non_method(){}

    static int static_field;
    static void static_method(){}

    B field1 = new B();
    C field2 = new C();

    public A(){
        System.out.println("A 객체가 생성됨");
    }

    void method1(){
        B var1 = new B();
        C var2 = new C();
    }

    //static B filed3 = new B();
    static C field4 = new C();

    static void method2(){
        //B var1 = new B();
        C var2 = new C();
    }

    /*인스턴스 멤버 클래스*/
    class B{
        public B(){System.out.println("B 객체가 생성됨");}
        int field1;
        //static int field2; 안됨
        public void method1(){}
        //static void method2(); 안됨
        public void method(){
            non_field = 10;
            non_method();

            static_field = 10;
            static_method();
        }
    }

    /*정적 멤버 클래스*/
    public static class C{
        public C(){System.out.println("C 객체가 생성됨");}
        int field1;
        static int field2;
        public void method1(){}
        public static void method2(){}
        public void method(){
            //non_field = 10; 불가능
            //non_method();   불가능

            static_field = 10;
            static_method();
        }
    }

    public void method(){
        /*로컬 클래스*/
        class D{
            public D(){System.out.println("D객체가 생성됨");}
            int field1;
            //static int field2; 안됨
            public void method1(){}
            //static void method2() 안됨
        }
        D d = new D();
        d.field1 = 3;
        d.method1();
    }

    public interface I{
        public abstract void method();
    }

}
