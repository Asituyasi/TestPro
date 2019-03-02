package muitithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc :
 * Created by tiantian on 2018/10/22
 */
public class CountDownLatchDemo implements Runnable{
    static CountDownLatch end = new CountDownLatch(10);
    static CountDownLatchDemo demo =new CountDownLatchDemo();
    
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " start");
        end.countDown();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(demo);
        }
        end.await();
        System.out.println("all start");
    }
}
