package com.syz.java.test.mess;

/**
 * @Author steven.sheng
 * @Date 2020/3/20/02017:23
 */
public class NativeTest {
    static {
        System.loadLibrary("NativeTest");
    }

    public static native void sayHello();

    public static void main(String[] args) {
        sayHello();
    }
}
