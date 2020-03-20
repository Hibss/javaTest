package com.syz.java.test.mess;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author steven.sheng
 * @Date 2018/12/4/004.
 */
public class CglibSample {
    public void hello(){
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"D:\\test");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibSample.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method start");
                Object result = methodProxy.invokeSuper(o,objects);
//                result = method.invoke(o,objects);
                System.out.println("before method finish");
                return result;
            }
        });
        CglibSample sample = (CglibSample) enhancer.create();
        sample.hello();
    }
}
