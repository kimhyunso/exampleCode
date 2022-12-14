package chapter08;

public class VehicleEx {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();
        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }

}
