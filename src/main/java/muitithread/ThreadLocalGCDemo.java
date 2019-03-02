package muitithread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc :
 * Created by tiantian on 2018/10/30
 */
public class ThreadLocalGCDemo {
    private volatile static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();
    private volatile static CountDownLatch cd = new CountDownLatch(10000);
    
    static class ParseDate implements Runnable{
        int i;

        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.toString() + " is GC.");
        }

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (tl.get() == null) {
                    // 在应用层面保证每个线程有一个SimpleDateFormat对象
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + " is GC.");
                        }
                    });
                    System.out.println(Thread.currentThread().getId() + ": created SimplaDateFormat" );
                }
                Date date = tl.get().parse("2015-03-29 19:29:" + i%60);
                //System.out.println(i + " : " + date);
            } catch (ParseException e) {
                e.printStackTrace();
            } finally {
                cd.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }
        
        cd.await();
        System.err.println("mission complete.");
        tl = null;
        System.gc();
        System.err.println("first GC complete");
        
        Thread.sleep(1000);
        
        tl = new ThreadLocal<SimpleDateFormat>();
        cd = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            es.execute(new ParseDate(i));
        }

        cd.await();
        tl = null;
        System.gc();
        System.err.println("second GC complete");
    }
}
