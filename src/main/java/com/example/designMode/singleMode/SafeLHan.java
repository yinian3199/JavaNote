package com.example.designMode.singleMode;

/**
 * @author lixiang
 * @date 2021/3/29 23:24
 * 是否lazy初始化：是
 * 是否多线程安全：是
 * 实现难度：易
 * 特点：优点：第一次调用才初始化，避免内存浪费。
 *      缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 *      getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）
 */
public class SafeLHan {
    public static SafeLHan instance;

    private SafeLHan(){

    }

    public static synchronized SafeLHan getInstance(){
        if (instance == null){
            instance = new SafeLHan();
        }
        return instance;
    }
}
