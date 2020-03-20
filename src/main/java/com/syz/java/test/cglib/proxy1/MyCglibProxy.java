package com.syz.java.test.cglib.proxy1;

import org.apache.log4j.Logger;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class MyCglibProxy implements MethodInterceptor {

    private Logger log= Logger.getLogger(MyCglibProxy.class);

    public Enhancer enhancer = new Enhancer();
    private String name;

    private final String Administrator = "admin";

    public MyCglibProxy(String name) {
        this.name = name ;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("调用的方法是：" + method.getName());
        //用户进行判断
        if(!Administrator.equals(name)){
            System.out.println("你没有权限！");
            return null;
        }
        Object result = methodProxy.invokeSuper(object, args);

        return result;
    }


    /**
     * 根据class对象创建该对象的代理对象
     * 1、设置父类；2、设置回调
     * 本质：动态创建了一个class对象的子类
     *
     * @param cls
     * @return
     */
    public Object getDaoBean(Class cls) {
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }


}
