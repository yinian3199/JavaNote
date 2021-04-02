package com.example.designMode.singleMode;

/**
 * @author lixiang
 * @date 2021/3/29 23:21
 * 是否lazy初始化：是
 * 是否多线程安全：否
 * 实现难度：易
 * 特点：这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
 * 因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class LHan {
    private static LHan instance;

    private LHan(){

    }

    public static LHan getInstance(){
        if (instance == null){
            instance = new LHan();
        }
        return instance;
    }
}
