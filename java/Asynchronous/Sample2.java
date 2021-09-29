package Asynchronous;

import java.util.concurrent.CompletableFuture;

public class Sample2
{
    public static int compute(){
     //   throw new RuntimeException("something went wrong");
      return 2;
    }
    public static CompletableFuture<Integer> create(){
        return  CompletableFuture.supplyAsync(()->compute());
    }

    public static void main(String[] args)
    {
    create()
            .thenApply(data->data*2)
            .thenAccept(data->System.out.println(data))
            .exceptionally(throwable -> handleException(throwable));
    }

    private static Void handleException(Throwable throwable) {
        System.out.println(throwable);
        throw new RuntimeException("it is beyond all hope");
    }
}