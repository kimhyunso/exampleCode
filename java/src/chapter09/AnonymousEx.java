package chapter09;

public class AnonymousEx {
    public static void main(String[] args) {
        /*Anonymous anony = new Anonymous();
        //익명 객체 필드 사용
        anony.field.wake();
        System.out.println("-------------------------------");

        //익명 객체 로컬 변수 사용
        anony.method1();
        System.out.println("-------------------------------");

        //익명 객체 매개값 사용
        anony.method2(
                new Person(){
                    public void study(){
                        System.out.println("공부합니다.");
                    }

                    @Override
                    public void wake() {
                        System.out.println("8시에 일어납니다.");
                        study();
                    }
                }
        );*/

        /*Anonymous anonymous = new Anonymous();

        anonymous.field1.turnOn();

        anonymous.method2();
        anonymous.method2(
                new RemoteControl() {
                    @Override
                    public void turnOn() {
                        System.out.println("SmartTV를 켭니다.");
                    }

                    @Override
                    public void turnOff() {
                        System.out.println("SmartTV를 끕니다.");
                    }
                }
        );*/

        Anonymous anonymous = new Anonymous();
        anonymous.method(0,0);


    }
}
