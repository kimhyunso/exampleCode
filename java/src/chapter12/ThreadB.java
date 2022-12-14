package chapter12;

public class ThreadB extends Thread{

    /*@Override
    public void run() {
        for(int i=0; i<2; i++){
            System.out.println(getName()+"가 출력한 내용");
        }
    }*/

    public boolean stop = false;
    public boolean work = true;
    @Override
    public void run() {
        while(!stop){
            if(work){
                System.out.println("ThreadB 작업 내용");
            }else{
                Thread.yield();
            }
        }
        System.out.println("스레드B 종료!");
    }
}
