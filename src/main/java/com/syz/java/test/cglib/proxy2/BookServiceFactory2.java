package com.syz.java.test.cglib.proxy2;

import com.syz.java.test.cglib.proxy0.BookServiceBean;
import com.syz.java.test.cglib.proxy1.MyCglibProxy;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class BookServiceFactory2 {
    private static BookServiceBean service = new BookServiceBean();
    private BookServiceFactory2() {
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
    public static BookServiceBean getAuthInstanceByFilter(MyCglibProxy myProxy){
        Enhancer en = new Enhancer();
        en.setSuperclass(BookServiceBean.class);
        en.setCallbackFilter(new MyProxyFilter());
        en.setCallbacks(new Callback[]{myProxy, NoOp.INSTANCE});
//        setCallbacks中定义了所使用的拦截器，其中NoOp.INSTANCE是CGlib所提供的实际是一个没有任何操作的拦截器，
//        他们是有序的,一定要和CallbackFilter里面的顺序一致。上面return返回(0/1)的就是返回的顺序。也就是说如果调用query方法就使用NoOp.INSTANCE进行拦截。
        return (BookServiceBean)en.create();
    }
}
