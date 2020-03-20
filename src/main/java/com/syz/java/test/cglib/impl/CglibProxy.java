package com.syz.java.test.cglib.impl;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置需要创建的子类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //通过字节码技术 动态创建子类实例
        return this.enhancer.create();
    }
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置代理");
//        Object result = methodProxy.invoke(object,args);
        //调用父类中的方法
        Object result = methodProxy.invokeSuper(object,args);
        System.out.println("后置代理");
        return result;
    }
}
