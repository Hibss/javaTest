package com.syz.java.test.cglib.proxy0;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class Client {
    public static void main(String[] args) {
        BookServiceBean service = BookServiceFactory.getInstance();
        doMethod(service);
    }
    public static void doMethod(BookServiceBean service){
        service.create();
        service.update();
        service.query();
        service.delete();
    }
}
