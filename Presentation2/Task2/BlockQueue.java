package Presentation2.Task2;


import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueue {

    public static void main(String[] args) throws IOException {

        BlockingQueue<String> blockingQueue =new ArrayBlockingQueue<String>(5);




        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<5) {
                    blockingQueue.add("Nazar" + i);
                    i++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }


            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i<5){
                    try {
                        System.out.println(blockingQueue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    i++;
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
