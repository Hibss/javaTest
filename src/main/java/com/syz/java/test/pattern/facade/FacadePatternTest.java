package com.syz.java.test.pattern.facade;

/**
 * @Author steven.sheng
 * @Date 2019/1/8/008.
 */
public class FacadePatternTest {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawSquare();
        System.out.println(shapeMaker.circleSize());
        System.out.println(shapeMaker.squareSize());
    }
}
