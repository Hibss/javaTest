package com.syz.java.test.math;

import org.omg.SendingContext.RunTime;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @ProjectName: javaTest
 * @Package: com.syz.java.test.math
 * @ClassName: IntegerTest
 * @Author: Administrator
 * @Description:
 * @Date 2020/1/4/00415:15
 */
public class IntegerTest {
    public static void main(String[] args) {
        testPrime();
//        testInteger();
    }

    private static void testPrime() {
        sum();
//        List<Integer> numbers = initNumbers(100);
        System.out.println();
    }

    private static void sum() {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1,10000).forEach(accumulator::add);
        System.out.println(accumulator.total);
    }

    public static class Accumulator{
        public Long total= 0L;
        public void add(Long n){
            total += n;
        }
    }

    public static <T> List<T> checkPrime(List<T> list, Predicate<T> predicate){
        Integer index = 0;
        for (T t : list) {
            if(!predicate.test(t)){
                return list.subList(0,index);
            }
            index++;
        }
        return list;
    }
    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    private static List<Integer> initNumbers(int max) {
        return IntStream.rangeClosed(0,max).boxed().collect(Collectors.toList());
    }

    private static void testInteger() {
        Integer start = Integer.MAX_VALUE - 10,
                end,
                count = 0;
        for (int i = 0; i < 20; i++) {
            count++;
            end = start + count;
            System.out.println("count:" + count + ",number：" + end);
        }

    }
}
