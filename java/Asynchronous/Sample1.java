package Asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Sample1
{
    public static CompletableFuture<Integer> create(){
        return  CompletableFuture.supplyAsync(()->2);
    }

    public static int compute(){
        sleep(1000);
        return 2;
    }

    private static boolean sleep(int i) {
        try {
            Thread.sleep(i);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> future=create();
//        CompletableFuture<Void> future2= future.thenAccept(data->System.out.println(data));

//        create()
//                .thenAccept(data->System.out.println(data))
//                .thenRun(()->System.out.println("Really, this never dies"));

//        CompletableFuture<Integer> future=create();
//        System.out.println("got it");

//        create().get();//bad idea, not good method to
//        System.out.println( create().get());

//        System.out.println(create().getNow(0));
//        System.out.println("here");

//        create()
//                .thenAccept(data->printIt(data));

//        CompletableFuture<Integer>future=create();
//        sleep(1000);
//        future.thenAccept(data->printIt(data));

//        create()
//                .thenApply(data->data*10.0)
//                .thenAccept(data->System.out.println(data))
//                .thenRun(()->System.out.println("That went well"));
//

        CompletableFuture<Integer> future =
                new CompletableFuture<>();
        future.thenApply(data->data * 2)
                .thenApply(data->data+1)
                .thenAccept(data->System.out.println(data));
        System.out.println("build the pipeline");
        sleep(1000);
        System.out.println("prepared to print");
        sleep(1000);
        future.complete(2);
        sleep(1000);
    }
    private static void printIt(Integer data) {
        System.out.println(data+"--"+Thread.currentThread());
    }
}
