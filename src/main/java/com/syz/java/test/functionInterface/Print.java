package com.syz.java.test.functionInterface;

/**
 * @ProjectName: javaTest
 * @Package: com.syz.java.test.functionInterface
 * @ClassName: Print
 * @Author: Administrator
 * @Description:
 * @Date 2020/1/3/00315:27
 */
@FunctionalInterface
public interface Print<T> {
    /**
     * 打印
     * @param str
     */
    void print(T str);

}
