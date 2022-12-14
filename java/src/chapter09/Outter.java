package chapter09;

import java.io.OutputStream;

public class Outter {
    //자바 7버전
    public void method1(final int arg){
        final int localVariable = 1;
        class Inner{
            public void method(){
                int result = arg + localVariable;
            }
        }
    }
    //자바 8버전 이후 final 생략가능
    public void method2(int arg){
        int localVariable = 1;
        class Inner{
            public void method(){
                int result = arg + localVariable;
            }
        }
    }

    String field = "Outter-field";

    public void method(){
        System.out.println("Outter-field");
    }


    class Nested{
        String field = "Nested-field";
        public void method(){
            System.out.println("Nested-method");
        }
        public void print(){
            System.out.println(this.field);
            this.method();

            System.out.println(Outter.this.field);
            Outter.this.method();
        }
    }





}
