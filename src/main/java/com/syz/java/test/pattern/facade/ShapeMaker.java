package com.syz.java.test.pattern.facade;

/**
 * @Author steven.sheng
 * @Date 2019/1/8/008.
 */
public class ShapeMaker {
    private Shape circle;
    private Shape square;

    ShapeMaker(){
        circle = new Circle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void  drawSquare(){
        square.draw();
    }

    public Integer circleSize(){
        return circle.size();
    }
    public Integer squareSize(){
        return square.size();
    }
}
