package com.example.proxy.dynamic.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lixiang
 * @date 2021/4/13 22:00
 */
public class MyInvocationHandler implements InvocationHandler {

    //代理类中的真实对象
    private final Object target;

    public MyInvocationHandler(Object target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method:"+method.getName());
        Object result = method.invoke(target,args);
        System.out.println("after method:"+method.getName());
        return result;
    }

}
