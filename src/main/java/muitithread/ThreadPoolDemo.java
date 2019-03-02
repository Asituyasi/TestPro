package muitithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc :
 * Created by tiantian on 2018/10/22
 */
public class ThreadPoolDemo {
    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " Thread ID: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            es.submit(task);
        }
    }
}
