package com.syz.java.test.cglib.proxy2;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class MyProxyFilter implements CallbackFilter {
    private final String Accept_Method = "query";
    @Override
    public int accept(Method method) {
        if(Accept_Method.equalsIgnoreCase(method.getName())){
            return 1;
        }
        return 0;
    }
}
