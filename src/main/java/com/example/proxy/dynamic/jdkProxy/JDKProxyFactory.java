package com.example.proxy.dynamic.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @author lixiang
 * @date 2021/4/13 22:04
 */
public class JDKProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new MyInvocationHandler(target));
    }
}
