package com.syz.java.test.cglib.impl;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class Client {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Hello hello = (Hello) proxy.getProxy(Hello.class);
        hello.hello();
    }
}
