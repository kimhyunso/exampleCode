package chapter08;

public class CarEx {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();
        System.out.println("-------------------------");

        myCar.tires[0] = new KumhoTire();
        myCar.tires[1] = new KumhoTire();
        /*myCar.frontRightTire = new KumhoTire();
        myCar.frontLeftTire = new KumhoTire();*/
        myCar.run();

    }


}
