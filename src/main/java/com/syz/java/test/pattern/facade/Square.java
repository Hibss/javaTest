package com.syz.java.test.pattern.facade;

/**
 * @Author steven.sheng
 * @Date 2019/1/8/008.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("square draw");
    }

    @Override
    public void paint() {
        System.out.println("square paint");

    }

    @Override
    public void write() {
        System.out.println("square write");
    }
}
