package com.syz.java.test.pattern.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class BookProxy implements MethodInterceptor {

    private Object result;

    public Object getInstance(Object target){
        this.result = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin");
        methodProxy.invokeSuper(o,objects);
        System.out.println("end");
        return null;
    }
}
