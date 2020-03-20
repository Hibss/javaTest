package com.syz.java.test.pattern.facade;

/**
 * @Author steven.sheng
 * @Date 2019/1/8/008.
 */
public interface Shape {
    void draw();
    void paint();
    void write();

    default int size() {
        return 0;
    }
}
