package chapter07;

public class CarEx {
    public static void main(String[] args) {
        Car car = new Car();
        /*for(int i=1; i<=5; i++){
            int problemLocation = car.run();

            switch (problemLocation){
                case 1:
                    System.out.println("앞왼쪽 HankooTire로 교체");
                    car.fontLeftTire = new HankooTire("앞왼쪽",15);
                    break;
                case 2:
                    System.out.println("앞오른쪽 KumhoTire로 교체");
                    car.fontRightTire = new KumhoTire("앞오른쪽",13);
                    break;
                case 3:
                    System.out.println("뒤왼쪽 HankooTire로 교체");
                    car.backLeftTire = new HankooTire("뒤왼쪽",14);
                    break;
                case 4:
                    System.out.println("뒤오른쪽 HankooTire로 교체");
                    car.backLeftTire = new HankooTire("뒤오른쪽",17);
                    break;
            }
            System.out.println("----------------------------------------------------");

        }*/

        for(int i=1; i<=5; i++){
            int problemLocation = car.run();
            if(problemLocation != 0){
                System.out.println(car.tires[problemLocation-1].location+" HankooTire로 교체");
                car.tires[problemLocation-1] = new HankooTire(car.tires[problemLocation-1].location,15);
            }
            System.out.println("---------------------------------------");
        }

    }

}
