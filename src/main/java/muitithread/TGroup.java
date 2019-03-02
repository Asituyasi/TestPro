package muitithread;

/**
 * desc :
 * Created by tiantian on 2018/8/30
 */
public class TGroup implements Runnable{
    
    
    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() +"-"+ Thread.currentThread().getName();
        while (true) {
            System.out.println("I'm " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new TGroup(), "T1");
        Thread t2 = new Thread(tg, new TGroup(), "T2");
        t1.start();
        t2.start();

        System.out.println(tg.activeCount());
        tg.list();
    }
}
