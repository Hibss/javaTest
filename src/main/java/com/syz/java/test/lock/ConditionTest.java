package com.syz.java.test.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author steven.sheng
 * @Date 2020/5/6/00615:35
 */
public class ConditionTest {
    private static Lock lock=new ReentrantLock();
    private static Condition condition=lock.newCondition();
    public static void main(String[] args) {
        Thread t1=new Thread(new task1(),"task1");
        Thread t2=new Thread(new task2(),"task2");
        t1.start();t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static class task1 implements Runnable{
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"开始执行");
            try {
                System.out.println(Thread.currentThread().getName()+"释放锁");
                condition.await();
                //lock释放锁
                System.out.println(Thread.currentThread().getName()+"重新获取到锁,执行完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
    public static class task2 implements Runnable{
        @Override
        public void run() {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"开始执行");
            condition.signal();
            System.out.println(Thread.currentThread().getName()+"开始唤醒其他线程");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完成");
            lock.unlock();
        }
    }
}
