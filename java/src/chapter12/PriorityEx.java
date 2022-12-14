package chapter12;

public class PriorityEx {
    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            Thread thread = new CalThread("thread"+i);
            if(i != 10)
                thread.setPriority(Thread.MIN_PRIORITY);
            else
                thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
        }

    }
}
