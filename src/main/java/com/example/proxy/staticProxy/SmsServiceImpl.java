package com.example.proxy.staticProxy;

/**
 * @author lixiang
 * @date 2021/4/12 23:39
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
