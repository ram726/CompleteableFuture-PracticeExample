package Asynchronous;

import java.util.concurrent.CompletableFuture;

public class Sample5 {
    public static CompletableFuture<Integer> create(int number){
        return CompletableFuture.supplyAsync(()->number);
    }
    public static CompletableFuture<Integer> inc(int number){
        return CompletableFuture.supplyAsync(()->number+1);
    }
    public static void main(String[] args) {
        create(2)
                //.thenApply(data->inc(data))
                .thenCompose(data->inc(data))
                .thenAccept(result->System.out.println(result));

    }
}
