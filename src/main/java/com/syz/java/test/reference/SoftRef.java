package com.syz.java.test.reference;

import java.lang.ref.SoftReference;

/**
 * @Author steven.sheng
 * @Date 2020/3/26/02611:33
 */
public class SoftRef {
    public static void main(String[] args) {
        System.out.println("-----------");
        Obj obj = new Obj();
        SoftReference<Obj> soft = new SoftReference<>(obj);
        obj = null;
        Obj obj1 = soft.get();
        System.out.println(obj1);
        System.out.println(obj1.aa);
        System.out.println("-----------");
    }
}
class Obj{
    String aa;
    public Obj(){
        aa = "123";
    }
}
