package Asynchronous;

import java.util.concurrent.CompletableFuture;

public class Sample3
{
    public static CompletableFuture<Integer> create(int number){
        return CompletableFuture.supplyAsync(()->number);
    }
    public static void main(String[] args) {
        create(2).thenCombine(create(3),(result1,result2)->result1+result2)
                .thenAccept(data->System.out.println(data));
    }
}
