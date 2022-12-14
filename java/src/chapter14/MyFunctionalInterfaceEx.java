package chapter14;

public class MyFunctionalInterfaceEx {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        /*fi = ()->{
            String str = "method call1";
            System.out.println(str);
        };
        fi.method();

        fi = () -> {System.out.println("method call2");};
        fi.method();

        fi = () -> {System.out.println("method call3");};
        fi.method();*/

        /*fi = (x) -> {
            int result = x * 5;
            System.out.println(result);
        };
        fi.method(2);

        fi = (x) ->{System.out.println(x*5);};
        fi.method(2);

        fi = x -> System.out.println(x*5);
        fi.method(2);*/

        fi = (x, y) -> {
            int result = x+y;
            return result;
        };
        System.out.println(fi.method(2,5));

        fi = (x,y) -> { return x+y;};
        System.out.println(fi.method(2,5));

        fi = (x,y) -> x+y;
        System.out.println(fi.method(2,5));

        fi = (x,y) -> sum(x,y);
        System.out.println(fi.method(2,5));
    }

    public static int sum(int x, int y){
        return x+y;
    }
}
