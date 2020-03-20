package com.syz.java.test.java8.lambda;

/**
 * @Author steven.sheng
 * @Date 2020/3/10/01015:33
 */
@FunctionalInterface
public interface FunctionProcess<T,R> {
    R apply(T t);
}
