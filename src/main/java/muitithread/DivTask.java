package muitithread;

import java.util.concurrent.*;

/**
 * desc :
 * Created by tiantian on 2018/10/24
 */
public class DivTask implements Runnable {
    int a,b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println(a/b);
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L,
//                TimeUnit.MILLISECONDS,
//                new SynchronousQueue<>());
//        for (int i = 0; i < 5; i++) {
//            DivTask divTask = new DivTask(100, i);
////            Future<?> future = pool.submit(divTask);
////            future.get();
//            pool.execute(divTask); // 异常不会打印任务提交的地方
//        }
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            DivTask divTask = new DivTask(100, i);
//            Future<?> future = pool.submit(divTask);
//            future.get();
            pool.execute(divTask);
        }
    }
}

// 定位任务提交的地方
class TraceThreadPoolExecutor extends ThreadPoolExecutor {
    public TraceThreadPoolExecutor(int corePoolSize, 
                                   int maximumPoolSize,
                                   long keepAliveTime, 
                                   TimeUnit unit, 
                                   BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }
    
    public Exception clientTrace() {
        return new Exception("Client Exception");
    }
    
    public Runnable wrap(final Runnable r, Exception clientStack, String threadName) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    r.run();
                } catch (Exception e) {
                    clientStack.printStackTrace();
                    throw e;
                }
            }
        };
    }

    @Override
    public void execute(Runnable command) {
        super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }
}
