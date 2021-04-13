package com.example.proxy.dynamic.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lixiang
 * @date 2021/4/13 23:02
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param o                 被代理的对象（需要增强的对象）
     * @param method            被拦截的方法（需要增强的方法）
     * @param objects           方法入参
     * @param methodProxy       用于调用原始方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method: "+method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("after method: "+method.getName());
        return result;
    }
}
