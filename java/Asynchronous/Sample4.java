package Asynchronous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sample4 {
    public static void main(String[] args) {
        List<Integer>numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        numbers.stream()
               // .map(e->func1(e))
               // .map(e->func2(e))
                .flatMap(e-> Stream.of(func2(e)))
                .forEach(System.out::println);
    }

    private static Object[] func2(Integer e) {
        return new Object[]{e-1,e+1};
    }

    private static int func1(Integer e) {
        return e*2;
    }
}
