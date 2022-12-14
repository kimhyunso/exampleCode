package chapter08;

public class RemoteControlEx {

    public static void main(String[] args) {
        /*RemoteControl rc = new RemoteControl() {
            @Override
            public void turnOn() {

            }

            @Override
            public void turnOff() {

            }

            @Override
            public void setVolume(int volume) {

            }
        };*/

        RemoteControl rc = null;

        rc = new Television();
        rc.turnOn();
        rc.setMute(true);

        rc = new Audio();
        rc.turnOn();
        //재정의된 메소드 실행
        rc.setMute(true);

        RemoteControl.changeBattery();
    }


}
