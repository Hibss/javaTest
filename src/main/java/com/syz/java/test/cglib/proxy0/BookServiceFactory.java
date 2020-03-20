package com.syz.java.test.cglib.proxy0;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class BookServiceFactory {
    private static BookServiceBean service = new BookServiceBean();
    private BookServiceFactory() {
    }
    public static BookServiceBean getInstance() {
        return service;
    }
}
