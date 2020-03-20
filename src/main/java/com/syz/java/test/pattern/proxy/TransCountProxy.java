package com.syz.java.test.pattern.proxy;

/**
 * 这是一个代理类（增强TransCountImpl实现类）
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class TransCountProxy implements TransCount {

    private TransCountImpl impl;

    public TransCountProxy(TransCountImpl impl){
        this.impl = impl;
    }

    @Override
    public void updateTransCount(String id) {
        System.out.println("before update TransCount");
        impl.updateTransCount(id);
        System.out.println("after update TransCount");
    }

    @Override
    public void queryTransCount(String id) {
        System.out.println("before read TransCount");
        impl.queryTransCount(id);
        System.out.println("after read TransCount");
    }
}
