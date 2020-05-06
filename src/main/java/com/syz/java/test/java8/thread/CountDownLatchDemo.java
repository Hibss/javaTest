package com.syz.java.test.java8.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author steven.sheng
 * @Date 2020/3/12/01215:31
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
//        testThread();
        testCountDownLatch();
    }

    private static void testCountDownLatch() {
        Integer size = 100;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i = 0; i < size; i++) {
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                System.out.println("计数:"+countDownLatch.getCount());
                countDownLatch.countDown();
            },"当前线程:"+i);
            t.run();
        }

    }

    private static void testThread() {

        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {

            try {

                Thread.sleep(7000);
                System.out.println("当前线程: " + Thread.currentThread().getName());

            } catch (InterruptedException ignore) {

            }

            // 休息 5 秒后(模拟线程工作了 5 秒)，调用 countDown()

            latch.countDown();

        }, "t1");

        Thread t2 = new Thread(() -> {

            try {

                Thread.sleep(10000);
                System.out.println("当前线程: " + Thread.currentThread().getName());

            } catch (InterruptedException ignore) {

            }

            // 休息 10 秒后(模拟线程工作了 10 秒)，调用 countDown()
            latch.countDown();

        }, "t2");

        t1.start();

        t2.start();

        Thread t3 = new Thread(() -> {

            try {

                // 阻塞，等待 state 减为 0

                latch.await();

                System.out.println("线程 t3 从 await 中返回了");
                System.out.println("当前线程: " + Thread.currentThread().getName());

            } catch (InterruptedException e) {

                System.out.println("线程 t3 await 被中断");

                Thread.currentThread().interrupt();
                System.out.println("当前线程: " + Thread.currentThread().getName());

            }

        }, "t3");

        Thread t4 = new Thread(() -> {

            try {

                // 阻塞，等待 state 减为 0

                latch.await();

                System.out.println("线程 t4 从 await 中返回了");
                System.out.println("当前线程: " + Thread.currentThread().getName());

            } catch (InterruptedException e) {

                System.out.println("线程 t4 await 被中断");

                Thread.currentThread().interrupt();

            }

        }, "t4");

        t3.start();

        t4.start();
    }

}
