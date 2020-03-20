package com.syz.java.test.pattern.dynamic.cglib;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class Client {
    public static void main(String[] args) {
        BookProxy proxy = new BookProxy();
        BookImpl impl = (BookImpl) proxy.getInstance(new BookImpl());
        impl.addBook();
    }
}
