package people;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Sample
{
    public static boolean check(int number) {
        System.out.println("t: "+number+"--"+Thread.currentThread());
        sleep(1000);
        return true;
    }
    public static int transform(int number) {
        System.out.println("t: "+number+"--"+Thread.currentThread());
        sleep(1000);
        return number*1;
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
    public static void printIt(int number) {
        System.out.println("p: "+number+"--"+Thread.currentThread());
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println();
        List<Integer>numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        //System.out.println(ForkJoinPool.commonPool());//givee details of common pool


        processs(numbers.parallelStream()
                .map(e->transform(e))
        );

//        numbers.parallelStream()
//                .map(e->transform(e))
//                .forEach(e->{});

//        numbers.stream()
//                .map(e->transform(e))
//                .forEach(e->{});

//        numbers.parallelStream()
//                .filter(e->check(e))
//                .forEachOrdered(e->{});

//        System.out.println(
//                numbers.stream()
//                        .reduce(25,(total,e)->add(total,e))
//        );
//        System.out.println(
//                numbers.parallelStream()
//                        .reduce(25,(total,e)->add(total,e))
//        );
    }

    private static void processs(Stream<Integer> stream) throws InterruptedException {
        ForkJoinPool pool=new ForkJoinPool(100);
        pool.submit(()->stream.forEach(e->{}));
        pool.shutdown();;
        pool.awaitTermination(10, TimeUnit.MILLISECONDS);
    }

    private static Integer add(Integer a, Integer b) {
        int result=a+b;
        System.out.println("a= "+a+" b= "+b+" result= "+result+"--"+Thread.currentThread());
        return  result;
    }
}