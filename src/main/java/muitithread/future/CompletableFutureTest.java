package muitithread.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    static class AskThread implements Runnable {
        private static CompletableFuture<Integer> future;

        public AskThread(CompletableFuture<Integer> future) {
            this.future = future;
        }

        @Override
        public void run() {
            System.out.println("task doing...");
            int res = 0;
            try {
                res = future.get() * future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("result="+res);
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        AskThread askTask = new AskThread(future);
        new Thread(askTask).start();
        Thread.sleep(1000);

        //Integer result = future.get();
        future.complete(11);
        Thread.sleep(1000);
        Integer result = future.get();
        System.out.println("In main() result="+result);
        //System.out.println("compute result="+result);
    }
    
    
}
