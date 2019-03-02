package muitithread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * desc : StampedLock缺陷
 * Created by tiantian on 2018/11/11
 */
public class StampedLockCPUDemo {
    static Thread[] holdCpuThreads = new Thread[3];
    static final StampedLock lock = new StampedLock();
    
    static class HoldCpuReadThread implements Runnable {
        @Override
        public void run() {
            long lockr = lock.readLock();
            System.out.println(Thread.currentThread().getName() + " 获得读锁");
            lock.unlock(lockr);
        }
    } 
    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            public void run() {
                long readLong = lock.writeLock();
                LockSupport.parkNanos(60000000000L);
                lock.unlockWrite(readLong);
            }
        }.start();
        Thread.sleep(100);
        
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i] = new Thread(new HoldCpuReadThread());
            holdCpuThreads[i].start();
        }
        Thread.sleep(10000);
        
        System.out.println("线程即将被中断");
        // 线程中断后会占用CPU
        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i].interrupt();
        }
    }
}
