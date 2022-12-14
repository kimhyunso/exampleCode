package chapter06;

public class CarEx {
    public static void main(String[] args) {
        /*Car myCar = new Car("검정",3000);

        //필드값 읽기
        System.out.println("제작회사: "+myCar.company);
        System.out.println("모델명: "+myCar.model);
        System.out.println("색깔: "+myCar.color);
        System.out.println("최고속도: "+myCar.maxSpeed);
        System.out.println("현재속도: "+myCar.speed);

        //필드값 쓰기
        myCar.speed = 60;
        System.out.println("수정된 속도: "+myCar.speed);*/

        /*Car car1 = new Car();
        System.out.println("car1.company : "+car1.company);
        System.out.println("----------------------------------------");

        Car car2 = new Car("자가용");
        System.out.println("car2.company : "+car2.company);
        System.out.println("car2.model : "+car2.model);
        System.out.println("----------------------------------------");

        Car car3 = new Car("자가용","빨강");
        System.out.println("car3.company : "+car3.company);
        System.out.println("car3.model : "+car3.model);
        System.out.println("car3.color : "+car3.color);
        System.out.println("----------------------------------------");

        Car car4 = new Car("택시","검정",200);
        System.out.println("car4.company : "+car4.company);
        System.out.println("car4.model : "+car4.model);
        System.out.println("car4.color : "+car4.color);
        System.out.println("car4.maxSpeed : "+car4.maxSpeed);
        System.out.println("----------------------------------------");*/

        /*Car myCar = new Car();
        myCar.setGas(5);

        boolean gasState = myCar.isLeftGas();
        if(gasState){
            System.out.println("출발합니다.");
            myCar.run();
        }

        if(myCar.isLeftGas())
            System.out.println("gas를 주입할 필요가 없습니다.");
        else
            System.out.println("gas를 주입하세요.");*/

        /*Car myCar = new Car();
        myCar.keyTurnOn();
        myCar.run();
        int speed = myCar.getSpeed();
        System.out.println("현재 속도: "+speed+"km/h");*/

        /*Car myCar = new Car();
        myCar.gas = 10;
        myCar.setSpeed(20);
        System.out.println("myCar gas:"+myCar.gas+" myCar speed:"+myCar.speed);

        Car yourCar = new Car();
        yourCar.gas = 20;
        yourCar.setSpeed(60);
        System.out.println("yourCar gas:"+yourCar.gas+" yourCar speed:"+yourCar.speed);*/

        /*Car myCar = new Car("포르쉐");
        Car yourCar = new Car("밴츠");

        myCar.run();
        yourCar.run();*/

       /* int width = 10, height = 5;

        double result1 = width * width * Calculator.pi;
        int result2 = Calculator.plus(width,height);
        int result3 = Calculator.minus(width,height);

        System.out.println("result1: "+result1);
        System.out.println("result2: "+result2);
        System.out.println("result3: "+result3);*/

       Car myCar = new Car();
       myCar.setSpeed(-50);

       System.out.println("현재 속도: "+myCar.getSpeed());

       myCar.setSpeed(60);

       System.out.println("현재 속도: "+myCar.getSpeed());
       if(!myCar.isStop())
           myCar.setStop(true);

       System.out.println("현재 속도: "+myCar.getSpeed());

    }
}
