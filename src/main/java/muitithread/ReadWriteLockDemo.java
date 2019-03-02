package muitithread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * desc : 读写锁
 * Created by tiantian on 2018/10/20
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;
    
    public Object readValue(Lock lock) throws InterruptedException {
        lock.lock();
        try {
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }
    
    public void writeValue(Lock lock, int val) throws InterruptedException {
        try {
            lock.lock();
            this.value = val;
            Thread.sleep(1000);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.readValue(readLock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.writeValue(writeLock, new Random().nextInt(20));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println("start");
        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }
        
    }
    
    
}
