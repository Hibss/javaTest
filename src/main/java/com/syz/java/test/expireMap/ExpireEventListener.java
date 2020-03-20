package com.syz.java.test.expireMap;

import net.jodah.expiringmap.ExpirationListener;

/**
 * @Author steven.sheng
 * @Date 2018/12/29/029.
 */
public class ExpireEventListener implements ExpirationListener{



    @Override
    public void expired(Object o, Object o2) {
        System.out.println("添加过期监听器ExpireEventListener");
        System.out.println(String.format("ExpireEventListener event : Map expire event : key %s, value %s",o,o2));
    }
}
