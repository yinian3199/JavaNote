package com.example.proxy.staticProxy;

import com.example.proxy.dynamic.cglib.CglibProxyFactory;
import com.example.proxy.dynamic.jdkProxy.JDKProxyFactory;

/**
 * @author lixiang
 * @date 2021/4/12 23:43
 */
public class SmsMain {
    public static void main(String[] args) {

        //静态代理
        SmsService smsService = new SmsServiceImpl();
        SmsProxy proxy = new SmsProxy(smsService);
        proxy.send("静态代理");

        System.out.println("**********************************");

        //jdk动态代理
        SmsService smsService1 = (SmsService) JDKProxyFactory.getProxy(new SmsServiceImpl());
        smsService1.send("jdk动态代理");

        System.out.println("**********************************");

        //cglib动态代理
        SmsService smsService2 = (SmsService) CglibProxyFactory.getProxy(SmsServiceImpl.class);
        smsService2.send("cglib动态代理");
    }
}
