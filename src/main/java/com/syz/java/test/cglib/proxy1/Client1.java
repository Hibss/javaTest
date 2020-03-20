package com.syz.java.test.cglib.proxy1;

import com.syz.java.test.cglib.proxy0.BookServiceBean;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class Client1 {
    public static void main(String[] args) {

        BookServiceBean service = BookServiceFactory1.getProxyInstance(new MyCglibProxy("admin"));
        doMethod(service);
        BookServiceBean service1 = BookServiceFactory1.getProxyInstance(new MyCglibProxy("123"));
        doMethod(service1);
    }
    public static void doMethod(BookServiceBean service){
        service.create();
        service.update();
        service.query();
        service.delete();
    }
}
