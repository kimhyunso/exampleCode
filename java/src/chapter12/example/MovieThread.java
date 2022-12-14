package chapter12.example;

public class MovieThread extends Thread{
    @Override
    public void run() {
        /*for(int i=0; i<3; i++){
            System.out.println("동영상을 재생합니다.");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){}
        }*/

        while(true){
            System.out.println("동영상을 재생합니다.");
            //방법 1
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                break;
            }
            //방법 2
            if(Thread.interrupted())
                break;
        }
    }
}
