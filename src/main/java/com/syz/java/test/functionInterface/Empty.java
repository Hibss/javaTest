package com.syz.java.test.functionInterface;

/**
 * @param <T>
 */
@FunctionalInterface
public interface Empty<T> {

    /**
     * 判断空
     * @param str
     * @return
     */
    boolean empty(T str);
}
