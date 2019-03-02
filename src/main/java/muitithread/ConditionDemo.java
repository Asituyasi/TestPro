package muitithread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                condition.await();
                System.out.println(Thread.currentThread().getName() +" go on run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new ConditionDemo());
        t.start();
        lock.lock();
        condition.signal();
        System.out.println(Thread.currentThread().getName() +" arose a thread.");
    }
}
