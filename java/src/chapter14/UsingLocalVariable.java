package chapter14;

public class UsingLocalVariable {
    public void method(int arg){
        int localVar = 40;

        MyInterface fi = () ->{
            System.out.println("arg: "+arg);
            System.out.println("localVar: "+localVar+"\n");
        };
        fi.method();
    }
}
