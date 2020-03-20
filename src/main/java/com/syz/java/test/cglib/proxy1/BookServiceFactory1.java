package com.syz.java.test.cglib.proxy1;

import com.syz.java.test.cglib.proxy0.BookServiceBean;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class BookServiceFactory1 {
    private static BookServiceBean service = new BookServiceBean();
    private BookServiceFactory1() {
    }
    public static BookServiceBean getInstance() {
        return service;
    }

    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy){
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(BookServiceBean.class);
        en.setCallback(myProxy);
        //生成代理实例
        return (BookServiceBean)en.create();
    }
}
