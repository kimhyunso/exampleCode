package chapter06;

public class CalculatorEx {
    public static void main(String[] args) {
        /*int x=5, y=6;
        Calculator myCal = new Calculator();
        myCal.powerOn();

        int result1 = myCal.plus(x,y);
        System.out.println("result1 : "+result1);

        byte xB = 10;
        byte yB = 4;
        double result2 = myCal.divide(xB,yB);
        System.out.println("result2 : "+result2);

        myCal.powerOff();*/

        /*Calculator myCal = new Calculator();
        myCal.execute();*/

        int width=10,height=20;
        Calculator myCal = new Calculator();
        double result1 = myCal.areaRectangle(width);

        double result2 = myCal.areaRectangle(width,height);

        System.out.println("정사각형의 넓이= "+result1);
        System.out.println("직사각형의 넓이= "+result2);
    }
}
