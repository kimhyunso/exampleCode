package chapter12;

public class ThreadWorkB extends Thread{
    private WorkObject workObject;

    public ThreadWorkB(WorkObject workObject){
        this.workObject = workObject;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            workObject.methodB();
        }
    }
}
