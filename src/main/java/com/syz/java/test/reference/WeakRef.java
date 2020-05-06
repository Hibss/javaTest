package com.syz.java.test.reference;

import java.lang.ref.WeakReference;

/**
 * @Author steven.sheng
 * @Date 2020/3/26/02611:38
 */
public class WeakRef {
    public static void main(String[] args) {
        WeakReference<String> weak = new WeakReference<>("123123");
        System.out.println(weak.get());
        System.gc();
        System.out.println(weak.get());
        WeakReference<String> weak1 = new WeakReference<>(new String("123121111"));
        System.out.println(weak1.get());
        System.gc();
        System.out.println(weak1.get());
    }
}
