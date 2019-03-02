package muitithread;


import java.util.concurrent.locks.ReentrantLock;

public class InteruptThread implements Runnable{
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int mark;

    public InteruptThread(int mark) {
        this.mark = mark;
    }

    @Override
    public void run() {
        try {
            if (mark == 1) {
                try {
                    lock1.lockInterruptibly();
                    Thread.sleep(1000);
                    lock2.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    lock2.lockInterruptibly();
                    Thread.sleep(1000);
                    lock1.lockInterruptibly();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + " quit.");
        }
       
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new InteruptThread(1));
        Thread t2 = new Thread(new InteruptThread(2));
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
