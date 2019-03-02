package muitithread;


import java.util.concurrent.*;

public class RejectThreadPoolDemo {
    static class Task implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " Thread ID: " + Thread.currentThread().getId());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        // 自定义线程池
//        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingDeque<>(10), 
//                Executors.defaultThreadFactory(), 
//                new RejectedExecutionHandler() {
//            @Override
//            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                System.out.println(r.toString() + " is discard");
//            }
//        });

        // 自定义创建线程
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread();
                        thread.setDaemon(true);
                        System.out.println("created " + thread);
                        return thread;
                    }
                });
                

        for (int i = 0; i < 5; i++) {
            poolExecutor.execute(task);
            Thread.sleep(10);
        }
    }
}
