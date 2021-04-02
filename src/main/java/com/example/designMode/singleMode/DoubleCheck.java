package com.example.designMode.singleMode;

/**
 * @author lixiang
 * @date 2021/3/29 23:34
 * 是否lazy初始化：是
 * 是否多线程安全：是
 * 实现难度：较复杂
 * 特点：这种方式采用双锁机制，安全且在多线程情况下保持高性能。
 *      getInstance()的性能对应用程序很关键。
 */
public class DoubleCheck {
    private volatile static DoubleCheck instance;

    private DoubleCheck(){

    }

    public static DoubleCheck getInstance() {
        if (instance == null){
            synchronized (DoubleCheck.class){
                if (instance ==null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
