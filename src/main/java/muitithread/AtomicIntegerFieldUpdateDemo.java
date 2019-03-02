package muitithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * desc :
 * Created by tiantian on 2018/10/31
 */
public class AtomicIntegerFieldUpdateDemo {
    static final AtomicIntegerFieldUpdater<Candidate> updater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class, "score");
    static AtomicInteger allScore = new AtomicInteger(0);
    static class Candidate {
        int id;
        volatile int score;
    }

    public static void main(String[] args) throws InterruptedException {
        final Candidate candidate = new Candidate();
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new Thread(()->{
                if (Math.random() > 0.4) {
                    updater.incrementAndGet(candidate);
                    allScore.incrementAndGet();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < 1000; i++) {
            threads[i].join();
        }

        System.out.println(candidate.score);
        System.out.println(allScore);
    }
}
