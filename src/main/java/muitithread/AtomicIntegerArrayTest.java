package muitithread;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * desc :
 * Created by tiantian on 2018/10/30
 */
public class AtomicIntegerArrayTest {
    private static final AtomicIntegerArray arr = new AtomicIntegerArray(10); 
    
    static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                arr.getAndIncrement(i%arr.length());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AddThread());
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println(arr.toString());
    }
}
