package chapter12;

public class WaitNotifyEx {
    public static void main(String[] args) {
        /*WorkObject sharedObject = new WorkObject();

        ThreadWorkA threadA = new ThreadWorkA(sharedObject);
        ThreadWorkB threadB = new ThreadWorkB(sharedObject);

        threadA.start();
        threadB.start();*/

        DataBox dataBox = new DataBox();

        ProducerThread producerThread = new ProducerThread(dataBox);
        ConsumerThread consumerThread = new ConsumerThread(dataBox);

        producerThread.start();
        consumerThread.start();
    }
}
