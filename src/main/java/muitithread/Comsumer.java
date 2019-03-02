package muitithread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * desc :
 * Created by tiantian on 2018/11/2
 */
public class Comsumer implements Runnable {
    private BlockingQueue<User> queue;
    private static final int SLEEPTIME = 1000;

    public Comsumer(BlockingQueue<User> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id=" + Thread.currentThread().getId());;
        Random random = new Random();

        try {
            while (true) {
                User u = queue.take();
                if (null != u) {
                    System.out.println("[Consumer:] get user and user id is :" +u.getId());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<User> queue = new LinkedBlockingQueue<>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Comsumer comsumer1 = new Comsumer(queue);
        Comsumer comsumer2 = new Comsumer(queue);
        Comsumer comsumer3 = new Comsumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(comsumer1);
        service.execute(comsumer2);
        service.execute(comsumer3);
        
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();
        
        Thread.sleep(3000);
        service.shutdown();
    }
}
