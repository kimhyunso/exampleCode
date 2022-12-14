package chapter08;

public class Car {
    Tire[] tires = {
        new HankooTire(),
        new HankooTire(),
        new HankooTire(),
        new HankooTire()
    };
    /*Tire frontLeftTire = new HankooTire();
    Tire frontRightTire = new HankooTire();
    Tire backLeftTire = new HankooTire();
    Tire backRightTire = new HankooTire();*/

    void run(){
        int cnt = 0;
        for(Tire tire : tires){
            if(cnt == 0) tire.roll("frontLeftTire");
            else if(cnt == 1) tire.roll("frontRightTire");
            else if(cnt == 2) tire.roll("backLeftTire");
            else if(cnt == 3) tire.roll("backRightTire");
            cnt++;
        }

        /*frontLeftTire.roll("frontLeftTire");
        frontRightTire.roll("frontRightTire");
        backLeftTire.roll("backLeftTire");
        backRightTire.roll("backRightTire");*/
    }
}
