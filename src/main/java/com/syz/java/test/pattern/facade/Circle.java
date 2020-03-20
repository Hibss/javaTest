package com.syz.java.test.pattern.facade;

/**
 * @Author steven.sheng
 * @Date 2019/1/8/008.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("circle draw");
    }

    @Override
    public void paint() {
        System.out.println("circle paint");

    }

    @Override
    public void write() {
        System.out.println("circle write");

    }

    @Override
    public int size(){
        return  111;
    }
}
