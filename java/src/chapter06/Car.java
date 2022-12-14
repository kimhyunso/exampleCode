package chapter06;

import java.awt.*;

public class Car {
    /*//필드
    String company = "현대자동차";
    String model = "그랜저";
    String color = "검정";
    int maxSpeed = 350;
    int speed;

    //오버로딩
    public Car(){}

    //오버로딩
    public Car(String model){
        //this.model = model;
        this(model,"은색",250);
    }

    //오버로딩
    public Car(String model,String color){
        //this.model = model;
        //this.color = color;
        this(model,color,250);
    }

    //오버로딩
    public Car(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }*/

    /*int gas;

    public void setGas(int gas){
        this.gas = gas;
    }

    public boolean isLeftGas(){
        if(gas == 0){
            System.out.println("gas가 없습니다.");
            return false;
        }
        System.out.println("gas가 있습니다.");
        return true;
    }

    public void run(){
        while(true){
            if(gas > 0){
                System.out.println("달립니다.(gas잔량: "+gas+")");
                gas -= 1;
            }else{
                System.out.println("멈춥니다.(gas잔량: "+gas+")");
                return;
            }
        }
    }*/

    /*int speed;

    public Car(){

    }

    public int getSpeed(){
        return speed;
    }

    public void keyTurnOn(){
        System.out.println("키를 돌립니다.");
    }

    public void run(){
        for(int i=10; i<=50; i+=10){
            speed = i;
            System.out.println("달립니다.(시속:"+speed+"km/h)");
        }
    }*/

    /*int gas;
    int speed;
    public Car(){}

    public void setSpeed(int speed){
        this.speed = speed;
    }*/

    /*String model;
    int speed;

    public Car(){

    }
    public Car(String model){
        this.model = model;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void run(){
        for(int i=10; i<=50; i+=10){
            this.setSpeed(i);
            System.out.println(this.model+"가 달립니다.(시속:"+this.speed+"km/h)");
        }
    }*/

    private int speed;
    private boolean stop;

    public Car(){}

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed < 0){
            this.speed = 0;
            return;
        }else
            this.speed = speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        this.speed = 0;
    }
}

