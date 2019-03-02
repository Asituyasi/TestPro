package muitithread.future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static Integer cal(Integer i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return i*i;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->cal(10))
                .exceptionally(ex-> {
                    System.out.println(ex.getStackTrace());
                    return 0;
                });
        Integer result = future.get();

        System.out.println("result:"+result);
    }
    
    
}
