package muitithread;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    static class Soldier implements Runnable{
        private String name;
        private final CyclicBarrier barrier;

        public Soldier(String name, CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                barrier.await();
                doWork();
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        
        public void doWork() throws InterruptedException {
            Thread.sleep(new Random().nextInt(3000));
            System.out.println(name + " complete work");
        }
    }
    
    static class BarrierRun implements Runnable{
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("Commonder : " + N + " soldiers have complete work.");
            } else {
                System.out.println("Commonder : " + N + " soldiers have gathered.");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        boolean flag = false;
        Thread[] allSoldier = new Thread[N];
        
        CyclicBarrier barrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("Soldier gathing");
        for (int i = 0; i < N; i++) {
            System.out.println("Soldier" +i +" be there");
            allSoldier[i] = new Thread(new Soldier("Soldier" + i, barrier));
            allSoldier[i].start();
        }
        
    }
}
