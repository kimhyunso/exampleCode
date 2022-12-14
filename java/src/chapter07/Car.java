package chapter07;

public class Car {

    /*Tire fontLeftTire = new Tire("앞왼쪽",6);
    Tire fontRightTire = new Tire("앞오른쪽",2);
    Tire backLeftTire = new Tire("뒤왼쪽",3);
    Tire backRightTire = new Tire("뒤오른쪽",4);*/

    Tire[] tires = {
            new Tire("앞왼쪽",6),
            new Tire("앞오른쪽",2),
            new Tire("뒤왼쪽",3),
            new Tire("뒤오른쪽",4)
    };

    int run(){
        System.out.println("[자동차가 달립니다.]");
        /*if(fontLeftTire.roll() == false){stop(); return 1;}
        if(fontRightTire.roll() == false){stop(); return 2;}
        if(backLeftTire.roll() == false){stop(); return 3;}
        if(backRightTire.roll() == false){stop(); return 4;}*/
        int cnt = 0;
        for(Tire tire : tires){
            if(tire.roll() == false){
                stop();
                return (cnt+1);
            }
            cnt++;
        }

        return 0;
    }

    void stop(){
        System.out.println("[자동차가 멈춥니다.]");
    }


}
