package muitithread;

public class JoinTest {
    
    public static volatile int i = 0;
    
    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (;i<100000;i++) {
                
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread a = new AddThread();
        a.start();
        a.join();
        System.out.println(i);
    }
}
