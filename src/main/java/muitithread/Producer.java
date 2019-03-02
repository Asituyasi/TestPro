package muitithread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * desc :
 * Created by tiantian on 2018/11/2
 */
public class Producer implements  Runnable{
    private volatile boolean isRunning = true;
    private BlockingQueue<User> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<User> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("start produce id="+Thread.currentThread().getId());
        while (isRunning) {
            try {
                Thread.sleep(random.nextInt(SLEEPTIME));
                User user = new User();
                user.setId(count.incrementAndGet());
                System.out.println("[Producer:] user is put into queue");
                if (!queue.offer(user, 2, TimeUnit.SECONDS)) {
                    System.err.println("failed to put data: " +user.toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void stop() {
        isRunning = false;
    }
}
