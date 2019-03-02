package muitithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * desc :
 * Created by tiantian on 2018/10/20
 */
public class ArrayListMultiThread {
    static volatile List<Integer> list = new ArrayList<>();
    
    static class AddThread implements Runnable {
        private Lock lock = new ReentrantLock(false);
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() +" get lock");
            for (int i = 0; i < 100000000; i++) {
                list.add(i);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        AddThread add = new AddThread();

        Thread thread = new Thread(add);
        Thread thread1 = new Thread(add);
        
        thread.start();
        thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }
}
