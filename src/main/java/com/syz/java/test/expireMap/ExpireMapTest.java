package com.syz.java.test.expireMap;

import net.jodah.expiringmap.ExpirationListener;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author steven.sheng
 * @Date 2018/12/29/029.
 */
public class ExpireMapTest {


    public static void main(String[] args) throws InterruptedException {
//        testExpirationPolicy();
//        testExpirationListening();
        testLazyLoad();
    }

    /**
     * 测试懒加载
     * 使用懒加载模式时，可以不用去向map中put对象，在调用get方法时自动去创建对象。
     */
    private static void testLazyLoad() throws InterruptedException {
        Map<String, User> map = ExpiringMap.builder().variableExpiration()
                .expiration(2,TimeUnit.SECONDS)
                .expirationListener((key,value)->{
                    System.out.println(String.format("lazyLoadTest expire : key %s ,value %s" , key , value));
                })
                .entryLoader(name->new User((String) name))
                .build();
        System.out.println(map.get("zhangsan"));
        Thread.sleep(3000);
    }

    static class User{
        String name;
        public User(String name){
            this.name = name;
        }
    }
    /**
     * 测试过期监听
     * @throws InterruptedException
     */
    private static void testExpirationListening() throws InterruptedException {
        System.out.println("---------测试过期监听start-----------------------");
        List<ExpirationListener> listeners = new ArrayList<>();
        listeners.add(new ExpireEventListener());
        listeners.add(new ExpireEventListener1());
        ExpiringMap<String,Object> map = ExpiringMap.builder()
                .variableExpiration()
                .expirationListener((key,value)->{
                    System.out.println(String.format("Map expire event : key %s, value %s",key,value));
                })
//                .expirationListeners(listeners)
                .build();
        //单个元素设置过期时间
        map.put("123","asddasd",ExpirationPolicy.CREATED, 1000, TimeUnit.MILLISECONDS);
        ExpireEventListener expireEventListener1 = new ExpireEventListener();
        map.addExpirationListener(expireEventListener1);
        ExpireEventListener1 expireEventListener11 = new ExpireEventListener1();
        map.addExpirationListener(expireEventListener11);
        Thread.sleep(1010);
        System.out.println("key:"+map.get("key"));

        map.put("asdasd",123123,1000,TimeUnit.MILLISECONDS);
        map.removeExpirationListener(expireEventListener1);
        map.removeExpirationListener(expireEventListener11);
        Thread.sleep(1010);
        System.out.println("key:"+map.get("asdasd"));
        System.out.println("---------测试过期监听 finish-----------------------");
    }

    /**
     * ExpirationPolicy.CREATED：在每次更新元素时，过期时间同时清零。
     * ExpirationPolicy.ACCESSED：在每次访问元素时，过期时间同时清零。
     * @throws InterruptedException
     */
    private static void testExpirationPolicy() throws InterruptedException {
        System.out.println("---------测试过期策略start-----------------------");
        ExpiringMap<String,Object> map = ExpiringMap.builder()
                .maxSize(10)
                .expiration(2, TimeUnit.SECONDS)
                .expirationPolicy(ExpirationPolicy.ACCESSED)
                .variableExpiration()
                .build();
        map.put("a",123);
        for (int i= 0;i<5;i++){
            System.out.println(String.format("expireMap get value %s at %d second.",map.get("a"),i));
            Thread.sleep(1000L);
        }

        ExpiringMap<String,Object> map1 = ExpiringMap.builder()
                .expirationPolicy(ExpirationPolicy.CREATED)
                .variableExpiration()
                .maxSize(10)
                .expiration(2, TimeUnit.SECONDS)
                .build();
        map1.put("a",123);
        for (int i= 0;i<5;i++){
            System.out.println(String.format("expireMap get value %s at %d second.",map1.get("a"),i));
            Thread.sleep(1000L);
        }
        System.out.println("---------测试过期策略finish-----------------------");

    }
}
