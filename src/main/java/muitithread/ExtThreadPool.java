package muitithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * desc : 
 * Created by tiantian on 2018/10/24
 */
public class ExtThreadPool {
    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行 " + Thread.currentThread().getId() + " Task name = " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行 ：" + ((MyTask) r).name );
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成 ：" + ((MyTask) r).name );

            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");

            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask myTask = new MyTask("Name" + i);
            es.execute(myTask);
            Thread.sleep(10);
        }
        
        es.shutdown();


    }
}

