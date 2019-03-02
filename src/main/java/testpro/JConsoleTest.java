package testpro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiantian on 2018/6/14.
 */
public class JConsoleTest {
    
    static class OOMObject {
        public byte[] bytes = new byte[64*1024];
    }
    
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }
    
    public static void creatBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    ;
            }
        }, "testBusyThead");
        
        thread.start();
    }
    
    public static void creatLockthread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }
    
    static class SynAddRunble implements Runnable {
        int a;
        int b;
        
        public SynAddRunble(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public void run() {
            synchronized (Integer.valueOf(a)){
                synchronized (Integer.valueOf(b)) {
                    System.err.println(a + b);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        for (int i = 0; i < 20; i++) {
            System.out.println("hhh");
        }
    }
}
