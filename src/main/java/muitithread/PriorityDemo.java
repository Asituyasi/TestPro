package muitithread;

/**
 * desc :
 * Created by tiantian on 2018/8/30
 */
public class PriorityDemo {
    
    public static class HightPriority extends Thread{
        static int count = 0;
        @Override
        public void run() {
            synchronized (PriorityDemo.class) {
                while (true) {
                    count++;
                    if (count >= 100000000) {
                        System.out.println("HightPriority completed");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread{
        static int count = 0;
        @Override
        public void run() {
            synchronized (PriorityDemo.class) {
                while (true) {
                    count++;
                    if (count >= 100000000) {
                        System.out.println("LowPriority completed");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread h = new HightPriority();
        Thread l = new LowPriority();
        
        h.setPriority(Thread.MAX_PRIORITY);
        l.setPriority(Thread.NORM_PRIORITY);
        
        l.start();
        h.start();
    }
}
