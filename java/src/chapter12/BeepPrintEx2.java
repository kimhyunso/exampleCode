package chapter12;

import java.awt.*;

public class BeepPrintEx2 {
    public static void main(String[] args) {
        /*Runnable beepTask = new BeepTask();
        Thread thread = new Thread(beepTask);
        thread.start();*/

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i=0; i<5; i++){
                    toolkit.beep();
                    try{
                        Thread.sleep(500);
                    }catch (Exception e){}
                }
            }
        });
        thread.start();

        /*Thread thread1 = new Thread(()->{
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for(int i=0; i<5; i++){
                toolkit.beep();
                try{
                    Thread.sleep(500);
                }catch (Exception e){}
            }
        });
        thread1.start();*/


        for(int i=0; i<5; i++){
            System.out.println("띵");
            try{
                Thread.sleep(500);
            }catch (Exception e){}
        }

    }
}
