package com.syz.java.test.java8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author steven.sheng
 * @Date 2020/3/20/02016:10
 */
public class SemaphoreTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore se = new Semaphore(3);
        for (int i = 0 ,size = 20; i < size ; i++){
            executorService.submit(new SemaphoreThread("i" + i,se));
        }
        executorService.shutdown();
    }
    static class SemaphoreThread extends Thread{
        private String name;
        private Semaphore semaphore;

        public SemaphoreThread(String name,Semaphore semaphore){
            this.name = name;
            this.semaphore = semaphore;
        }

        @Override
        public void run(){
            if(semaphore.availablePermits() > 0){
                System.out.println("有许可证可用");
            }else{
                System.out.println("无许可证可用");
            }
            try {
                semaphore.acquire();
                System.out.println(this.name + "在用");
                Thread.sleep(1000);
                semaphore.release();
                System.out.println(this.name + " 释放");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
