package chapter09;

public class Anonymous {
    /*//필드 초기값으로 대입
    Person field = new Person(){
      public void work(){
          System.out.println("출근합니다.");
      }

        @Override
        public void wake() {
            System.out.println("6시에 일어납니다.");
            work();
        }
    };

    public void method1(){
        //로컬 변수 값으로 대입
        Person localVar = new Person(){
          public void walk(){
              System.out.println("산착합니다.");
          }

            @Override
            public void wake() {
                System.out.println("7시에 일어납니다.");
            walk();
          }
        };

        //로컬 변수 사용
        localVar.wake();
    }

    public void method2(Person person){
        person.wake();
    }

    //필드 변수값으로 대입
    RemoteControl field1 = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV를 켭니다.");
        }

        @Override
        public void turnOff() {
            System.out.println("TV를 끕니다.");
        }
    };

    //로컬 변수값으로 대입
    public void method2(){
        RemoteControl localVar = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Audio를 켭니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("Audio를 끕니다.");
            }
        };

        localVar.turnOn();
    }

    public void method2(RemoteControl rc){
        rc.turnOn();
    }*/

    private int field;

    public void method(final int arg1, int arg2){
        final int val1 = 0;
        int var2 = 0;

        field = 10;

        Calculatable calc = new Calculatable() {
            @Override
            public int sum() {
                int result = field + arg1 +arg2 + val1 + var2;
                return result;
            }
        };

        System.out.println(calc.sum());
    }

}
