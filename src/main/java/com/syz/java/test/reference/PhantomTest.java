package com.syz.java.test.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author steven.sheng
 * @Date 2020/3/26/02611:54
 */
public class PhantomTest {
    public static void main(String[] args) {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        PhantomReference<String> pr = new PhantomReference<>(new String("123123"),referenceQueue);
        System.out.println(pr.get());
    }
}
