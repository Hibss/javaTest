package com.syz.java.test.pattern.proxy;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class Client {
    public static void main(String[] args) {
        TransCountImpl impl = new TransCountImpl();
        TransCountProxy proxy = new TransCountProxy(impl);
        proxy.updateTransCount("张三");
        proxy.queryTransCount("李四");
    }
}
