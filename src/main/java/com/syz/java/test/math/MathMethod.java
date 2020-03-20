package com.syz.java.test.math;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author steven.sheng
 * @Date 2019/7/31/03117:{}41
 */
@Slf4j
public class MathMethod {
    public static void main(String[] args) {
//        Fibonacci();
//        FibonacciNumber();
        FibSupplier();
    }

    private static void FibSupplier() {
        IntStream.generate(fib).limit(20).forEach(System.out::println);

    }

    static IntSupplier fib = new IntSupplier() {
        Integer pre = 0,cur = 1;
        @Override
        public int getAsInt() {
            int oldPre = pre,next = pre+cur;
            pre = cur;
            cur = next;
            return oldPre;
        }
    };
    private static void FibonacciNumber() {
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t->t[0])
                .forEach(System.out::println);
    }

    private static void Fibonacci() {
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[1] + t[0]})
                .limit(20)
                .forEach(t -> System.out.println(t[0] + "-----" + t[1]));

    }
}
