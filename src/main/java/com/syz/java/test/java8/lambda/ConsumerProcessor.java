package com.syz.java.test.java8.lambda;

/**
 * @Author steven.sheng
 * @Date 2020/3/10/01015:16
 */
@FunctionalInterface
public interface ConsumerProcessor<T> {
    void accept(T a);
}
