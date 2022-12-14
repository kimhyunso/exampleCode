package chapter08;

import chapter07.Phone;

public interface RemoteControl {
    public int MAX_VOLUME = 10; //상수
    public int MIN_VOLUME = 0;  //상수

    //추상 메소드들
    public void turnOn();
    public void turnOff();
    public void setVolume(int volume);

    //디폴트 메소드
    public default void setMute(boolean mute){
        if(mute)
            System.out.println("무음 처리합니다.");
        else
            System.out.println("무음 해제합니다.");
    }

    //정적 메소드
    public static void changeBattery(){
        System.out.println("건전지를 교환합니다.");
    }

}
