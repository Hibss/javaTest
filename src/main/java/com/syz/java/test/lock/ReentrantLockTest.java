package com.syz.java.test.lock;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author steven.sheng
 * @Date 2020/5/6/00616:34
 */
public class ReentrantLockTest {
    private static final Lock lock = new ReentrantLock(true);
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new Thread(()->{
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"执行");
                System.out.println(Thread.currentThread().getName()+"等待唤醒");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"被唤醒");
            }catch(Exception e){
                System.out.println(ExceptionUtils.getStackTrace(e));
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"thread1").start();
        new Thread(()->{
            try{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"执行");
                Thread.sleep(5000);
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"唤醒condition");
            }catch(Exception e){
                System.out.println(ExceptionUtils.getStackTrace(e));
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        },"thread2").start();
    }
}
