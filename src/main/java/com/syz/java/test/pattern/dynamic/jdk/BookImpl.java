package com.syz.java.test.pattern.dynamic.jdk;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class BookImpl implements BookInterface {
    @Override
    public void addBook() {
        System.out.println("add Book");
    }

    @Override
    public void delBook() {
        System.out.println("del Book");
    }

    @Override
    public void getBook() {
        System.out.println("get Book");
    }

    @Override
    public void updateBook() {
        System.out.println("udpate Book");
    }

    public void allBusiness(){
        this.addBook();
        delBook();
        updateBook();
        getBook();
    }
}
