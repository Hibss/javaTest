package com.syz.java.test.java8.completable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author steven.sheng
 * @Date 2020/3/13/01310:25
 */
public class CompletableTest {
    public static void main(String[] args) throws Exception{
        Integer max = 100;
//        IntStream.rangeClosed(0,max).mapToObj(a->{
//            Integer result = CompletableTest.getLongAsync(a);
//            return "calculate result : " + result;
//        }).forEach(System.out::println);

    }

    public static String getLongAsync(Integer number){
        return CompletableFuture.supplyAsync(()->calculate(number)).join();
    }

    public static CompletableFuture<String> getLongAsync1(Integer number){
        return CompletableFuture.supplyAsync(()->calculate(number));
    }

    private static String calculate(Integer number) {
        Integer reduce = IntStream.rangeClosed(0, number).reduce(0, Integer::sum);
        return reduce.toString();
    }
}
