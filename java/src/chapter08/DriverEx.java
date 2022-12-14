package chapter08;

public class DriverEx {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        //자동 타입변환
        driver.drive(bus);
        driver.drive(taxi);
    }
}
