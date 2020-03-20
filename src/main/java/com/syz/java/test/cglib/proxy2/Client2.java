package com.syz.java.test.cglib.proxy2;

import com.syz.java.test.cglib.proxy0.BookServiceBean;
import com.syz.java.test.cglib.proxy1.MyCglibProxy;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class Client2 {
    public static void main(String[] args) {

        BookServiceBean service = BookServiceFactory2.getAuthInstanceByFilter(new MyCglibProxy("admin"));
        doMethod(service);
        BookServiceBean service1 = BookServiceFactory2.getAuthInstanceByFilter(new MyCglibProxy("123"));
        doMethod(service1);
    }
    public static void doMethod(BookServiceBean service){
        service.create();
        service.update();
        service.query();
        service.delete();
    }
}
