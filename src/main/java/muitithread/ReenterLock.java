package muitithread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * desc : 重入锁
 * Created by tiantian on 2018/9/3
 */
public class ReenterLock implements Runnable{
    private ReentrantLock lock = new ReentrantLock();
    
    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
        System.out.println("done! " + Thread.currentThread().getName());
        System.out.println("i is " + i);
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock r = new ReenterLock();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        
        t1.start();
        t2.start();
        
        System.out.println(i);


    }
}
