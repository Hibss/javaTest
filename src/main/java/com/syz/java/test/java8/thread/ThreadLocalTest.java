package com.syz.java.test.java8.thread;

import com.syz.java.test.biz.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author steven.sheng
 * @Date 2020/3/26/02610:19
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        new Thread(() -> {
            Person.getInstance().setName("zhangsan");
            Person.getInstance().setAge(25);
            new A().getName();
            new B().getName();

        },"thread1").start();

        new Thread(() -> {
            Person.getInstance().setName("lisi");
            Person.getInstance().setAge(28);
            new A().getName();
            new B().getName();

        },"thread2").start();
    }
}
class A{
    public void getName(){
        System.out.println("A "+Thread.currentThread().getName()+":"+Person.getInstance().getAge()+":"+Person.getInstance().getName());
    }
}
class B {
    public void getName(){
        System.out.println("B "+Thread.currentThread().getName()+":"+Person.getInstance().getAge()+":"+Person.getInstance().getName());
    }
}

@Data
@NoArgsConstructor
class Person {
    // 优雅的设计方式，将ThreadLocal封装到bean内部，隐藏变化
    private static ThreadLocal<Person> instance = new ThreadLocal<>();
    private String name;
    private int age;

    public static Person getInstance() {
        Person p = instance.get();
        if (p == null) {
            p = new Person();
            instance.set(p);
        }

        return p;
    }
}