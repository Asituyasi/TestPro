package muitithread;

/**
 * desc :
 * Created by tiantian on 2018/8/23
 */
public class StopThreadUnsafe {
    public static User u = new User();
    
    public static class ChangeObjectThread extends Thread {
        public void run() {
            while (true) {
                int v  = (int) (System.currentTimeMillis()/1000);
                synchronized (u) {
                    u.setId(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setCode(v);
                }
                Thread.yield();
            }
        }
    }
    
    public static class ReadObjectThread extends Thread {
        public void run() {
            while (true) {
                if (u.getId() == u.getCode()) {
                    System.out.println(u.toString());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
            
            t.stop();
        }
    }
    
}
