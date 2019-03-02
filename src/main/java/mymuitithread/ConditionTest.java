package mymuitithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * desc :
 * Created by tiantian on 2018/10/20
 */
public class ConditionTest {
    private static volatile List<Integer> list = new ArrayList<>(11);
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition isEmpty = lock.newCondition();
    private static Condition isFull = lock.newCondition();
    
    static class OptionList implements Runnable{
        private String method;

        public OptionList(String method) {
            this.method = method;
        }

        @Override
        public void run() {
            if (method.equals("add")) {
                for (int i=0; i <= 10; i++) {
                    try {
                        add();
                        System.out.println(list.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    delete();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        private void add() throws InterruptedException {
            lock.lock();
            list.add(new Random().nextInt(99));
            if (list.size() > 0) {
                isEmpty.signal();
            }
            if (list.size() == 10) {
                System.out.println("list is full, waiting for del.");
                isFull.await();
            }
            lock.unlock();
        }
        
        private void delete() throws InterruptedException {
            lock.lock();
            for (int i = 0; i <list.size() ; i++) {
                list.remove(i);
            }

            if (list.isEmpty()) {
                System.out.println("is awaiting for add");
                isEmpty.await();
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        OptionList add = new OptionList("add");
        OptionList del = new OptionList("del");
        Thread addThread = new Thread(add);
        Thread delThread = new Thread(del);
        addThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delThread.start();
    }
}
