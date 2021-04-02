package com.example.designMode.singleMode;

/**
 * @author lixiang
 * @date 2021/3/29 23:40
 * 是否lazy初始化：是
 * 是否多线程安全：是
 * 实现难度：一般
 * 特点：这种方式能达到和双检锁方式一样的功效，但实现更简单。
 *      对静态域使用延迟初始化，应使用此方式而不是双检锁方式。
 *      这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 *      这种方式利用了classloader机制来保证初始化instance时只有一个线程，
 *      它与饿汉式不同的是，只要EHan类被装载了，那么instance就会实例化，
 *      饿汉式没有达到延迟加载的效果，而StaticInClass类被装载了，instance不一定被初始化，
 *      因为StaticInClassHolder类没有被主动使用，只有通过显示调用getInstance方法时，
 *      才会显示装载StaticInClassHolder类，从而实例化instance。
 * 使用场景：实例化instance很消耗资源，所以想让它延迟加载，另一方面，又不希望在StaticInClass加载时就实例化，
 *          因为不能确保StaticInClass类还可能在其他的地方被主动使用从而被加载，
 *          那么这个时候实例化instance显然是不合适的，这个时候，这种方式比之饿汉式更合理。
 */
public class StaticInClass {

    private StaticInClass(){

    }

    private static class StaticInClassHolder{
        private static final StaticInClass inClass = new StaticInClass();
    }

    public static final StaticInClass getInstance(){
        return StaticInClassHolder.inClass;
    }

}
