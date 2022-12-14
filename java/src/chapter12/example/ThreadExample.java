package chapter12.example;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new MovieThread();
        thread.setDaemon(true);
        thread.start();

        try{Thread.sleep(3000);}catch (InterruptedException e){}
    }
}
