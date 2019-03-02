package mymuitithread;


import muitithread.User;

public class WaitAndNotify implements Runnable{
    private static User user = new User();
    private Integer id;

    public WaitAndNotify(Integer id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (user) {
            if ((id % 2) == 0) {
                try {
                    user.wait();
                    System.out.println("After wait, " +Thread.currentThread().getName() + " is go on run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (id == 9) {
                    System.out.println(Thread.currentThread().getThreadGroup().getName());
                    System.out.println(Thread.currentThread().getName() + " is notifing all thread to run");
                    user.notifyAll();
                } else {
                    System.out.println(Thread.currentThread().getThreadGroup().getName());
                    System.out.println(Thread.currentThread().getName() +" pass。。。");
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadGroup threadGroup = new ThreadGroup("WaitAndNotifyGroup");

            Thread thread = new Thread(threadGroup,new WaitAndNotify(i));
            thread.setName("Thread" + i);
            thread.start();
            
        }
        
    }

}
