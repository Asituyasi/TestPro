package muitithread;


import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    static Object u = new Object();
    
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");
    
    static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.interrupted()) {
                    System.out.println(getName() + " 被中断了");
                }
                System.out.println(getName() +" 执行结束");
                // 直接挂起会导致主线程卡死
                //Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000);
        t2.start();

        t1.interrupt();
        LockSupport.unpark(t2);
        //LockSupport.unpark(t2);
        //t1.resume();
        //t2.resume();
        
        t1.join();
        t2.join();
    }
}
