package com.syz.java.test.pattern.proxy;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class TransCountImpl implements TransCount {
    @Override
    public void updateTransCount(String id) {
        System.out.println("update TransCount : "+id);
    }

    @Override
    public void queryTransCount(String id) {
        System.out.println("read TransCount : "+id);
    }
}
