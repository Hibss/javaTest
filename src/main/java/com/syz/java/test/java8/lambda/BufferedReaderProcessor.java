package com.syz.java.test.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author steven.sheng
 * @Date 2020/3/10/01014:56
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bf) throws IOException;
}
