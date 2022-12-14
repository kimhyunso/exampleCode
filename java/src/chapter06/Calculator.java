package chapter06;

public class Calculator {
    static double pi = 3.14159;

    static int plus(int x, int y){
        return x + y;
    }

    static int minus(int x, int y){
        return x-y;
    }

    public Calculator(){

    }


    /*public void powerOn(){
        System.out.println("전원을 켭니다.");
    }

    public int plus(int x, int y){
        return x+y;
    }

    public double divide(int x,int y){
        return (double)x/(double)y;
    }

    public void powerOff(){
        System.out.println("전원을 끕니다.");
    }*/

    /*public int plus(int x,int y){
        return x+y;
    }

    public double avg(int x,int y){
        double sum = plus(x,y);
        return sum / 2;
    }

    public void execute(){
        int x=7, y=10;
        double result = avg(x,y);
        println("실행결과: "+result);
    }

    public void println(String message){
        System.out.println(message);
    }*/

    //정사각형의 넓이
    public double areaRectangle(double width){
        return width * width;
    }

    //직사각형의 넓이
    public double areaRectangle(double width,double height){
        return width * height;
    }

}
