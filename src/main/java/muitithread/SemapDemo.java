package muitithread;

import java.util.concurrent.Semaphore;

/**
 * desc :
 * Created by tiantian on 2018/10/20
 */
public class SemapDemo implements Runnable{
    private Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " done!");
    }

    public static void main(String[] args) {
        SemapDemo semapDemo = new SemapDemo();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(semapDemo);
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
