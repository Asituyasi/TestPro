package muitithread;

/**
 * desc :
 * Created by tiantian on 2018/8/30
 */
public class DaemonT extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("I'm alive");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new DaemonT();
        t.setDaemon(true);// 不设置为守护线程将永远打印"I'm alive"
        t.start();
    }
}
