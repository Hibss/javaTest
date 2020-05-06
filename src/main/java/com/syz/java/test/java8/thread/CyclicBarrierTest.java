package com.syz.java.test.java8.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author steven.sheng
 * @Date 2020/3/20/02016:38
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        final CyclicBarrier barrier = new CyclicBarrier(20);
        final ExecutorService es = Executors.newFixedThreadPool(20);
        System.out.println("****等人齐****");
        for (int i = 0; i < 20; i++) {
            final int j = i + 1;
            Runnable person = () -> {
                try {
                    System.out.println(j + "号来了");
                    if (barrier.await() == 0) {
                        System.out.println("****人都到齐了****");
                    }
                    System.out.println(j + "号开吃");
                    if (barrier.await() == 0) {
                        System.out.println("****吃完了出发****");
                    }
                    System.out.println(j + "号玩好了");
                    if (barrier.await() == 0) {
                        System.out.println("****游玩结束回家****");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            es.submit(person);
        }
        es.shutdown();
    }
}
