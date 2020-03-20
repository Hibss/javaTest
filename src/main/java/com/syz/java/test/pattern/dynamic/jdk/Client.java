package com.syz.java.test.pattern.dynamic.jdk;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class Client {
    public static void main(String[] args) {
        BookProxy proxy = new BookProxy();
        BookInterface impl = (BookInterface) proxy.bind(new BookImpl());
        impl.addBook();
    }
}
