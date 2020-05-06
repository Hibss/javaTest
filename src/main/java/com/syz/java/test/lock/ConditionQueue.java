package com.syz.java.test.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author steven.sheng
 * @Date 2020/5/6/00617:10
 */
public class ConditionQueue {
    public static void main(String[] args) throws InterruptedException {
        LockBean bean = new LockBean();
        new Thread(()->{
            for (int i = 0; i < 200; i++) {
                try {
                    bean.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("put:"+i);
                System.out.println("put count:"+bean.count);
                System.out.println("put putptr:"+bean.putptr);
                System.out.println("put takeptr:"+bean.takeptr);
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 200; i++) {
                try {
                    bean.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("take:"+i);
                System.out.println("take count:"+bean.count);
                System.out.println("take putptr:"+bean.putptr);
                System.out.println("take takeptr:"+bean.takeptr);
            }
        }).start();
    }
   static class LockBean{
       final Lock lock = new ReentrantLock();//锁对象
       final Condition notFull = lock.newCondition();//写线程条件
       final Condition notEmpty = lock.newCondition();//读线程条件

       final Object[] items = new Object[100];//缓存队列
       int putptr/*写索引*/, takeptr/*读索引*/, count/*队列中存在的数据个数*/;

       public void put(Object x) throws InterruptedException {
           lock.lock();
           try {
               while (count == items.length)//如果队列满了
               {
                   notFull.await();//阻塞写线程
               }
               items[putptr] = x;//赋值
               if (++putptr == items.length) {
                   putptr = 0;//如果写索引写到队列的最后一个位置了，那么置为0
               }
               ++count;//个数++
               notEmpty.signal();//唤醒读线程
           } finally {
               lock.unlock();
           }
       }

       public Object take() throws InterruptedException {
           lock.lock();
           try {
               while (count == 0)//如果队列为空
               {
                   notEmpty.await();//阻塞读线程
               }
               Object x = items[takeptr];//取值
               if (++takeptr == items.length) {
                   takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0
               }
               --count;//个数--
               notFull.signal();//唤醒写线程
               return x;
           } finally {
               lock.unlock();
           }
       }
   }
}
