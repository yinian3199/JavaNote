package com.example.designMode.singleMode;

/**
 * @author lixiang
 * @date 2021/3/29 23:59
 * 是否lazy初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * 特点：这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。
 *      它更简洁，自动支持序列化机制，绝对防止多次实例化。
 *      它不仅能避免多线程同步问题，而且还自动支持序列化机制，
 *      防止反序列化重新创建新的对象，绝对防止多次实例化。
 *      同时不能通过 reflection attack 来调用私有构造方法。
 */
public enum EnumMode {
    INSTANCE;
    public void doSomething() {
        System.out.println("doSomething");
    }
}
