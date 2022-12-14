package chapter08;

public class Example {
    public static void main(String[] args) {
        ImplementationC implementationC = new ImplementationC();

        InterfaceA ia = implementationC;
        ia.methodA();
        System.out.println("---------------------------------------------");

        InterfaceB ib = implementationC;
        ib.methodB();
        System.out.println("--------------------------------------------");

        InterfaceC ic = implementationC;
        ic.methodA();
        ic.methodB();
        ic.methodC();

    }

}
