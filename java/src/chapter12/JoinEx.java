package chapter12;

public class JoinEx {
    public static void main(String[] args) {
        SumThread sumThread = new SumThread();
        sumThread.start();

        try{
            sumThread.join(); //메인 스레드를 잠시 일시정지 시킴
        }catch (InterruptedException e){}

        System.out.println("1~100까지의 합: "+sumThread.getSum());
    }
}
