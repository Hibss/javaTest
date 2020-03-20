package com.syz.java.test.expireMap;

import net.jodah.expiringmap.ExpirationListener;

/**
 * @Author steven.sheng
 * @Date 2018/12/29/029.
 */
public class ExpireEventListener1 implements ExpirationListener<String,Object> {
    @Override
    public void expired(String s, Object o) {

        System.out.println("添加过期监听器ExpireEventListener1");
        System.out.println(String.format("ExpireEventListener1 event : Map expire event : key %s, value %s",s,o));
    }
}
