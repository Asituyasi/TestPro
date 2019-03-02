package muitithread.disruptor;

/**
 * desc :
 * Created by tiantian on 2018/11/3
 */
public class FalseShareing implements Runnable {
    private static final int NUM_THREADS = 4;
    private static final long ITERATIONS = 500L*1000L*1000L;
    private final int arrayIndes;
    
    public static VolatileLong[] longs = new VolatileLong[NUM_THREADS];
    
    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public FalseShareing(int arrayIndes) {
        this.arrayIndes = arrayIndes;
    }
    
    

    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndes].value = i;
        }
    }
    
    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseShareing(i));
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
    
    public final static class VolatileLong {
        public volatile long value = 0L;
        // 仅用于填充高速缓存Cache
        public long p1,p2,p3,p4,p5,p6,p7;
    }

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        runTest();
        System.out.println("duration = " + (System.currentTimeMillis()-start));
        
    }
}

