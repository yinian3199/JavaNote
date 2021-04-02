package com.example.reflect;

/**
 * @author lixiang
 * @date 2021/3/31 22:56
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.知道具体类的情况
        Class target1 = TargetObject.class;


        //2.通过Class.forName传入类路径获取
        Class target2 =Class.forName("com.example.reflect.TargetObject");
        /**
         * Class.forName(className)方法，内部实际调用的是一个native方法，
         * forName0(className,true,ClassLoader.getClassLoader(caller),caller)
         * 第二个boolean参数表示类是否需要初始化，Class.forName(className)方法默认是需要初始化。
         * 一旦初始化，就会触发目标对象的static代码块执行，static参数也会再次被初始化
         */

        //3.通过对象实例instance.getClass()获取
        String s = new String();
        Class target3 = s.getClass();

        //4.通过类加载器xxxxClassLoader.loadClass()传入类路径获取
        Class target4 = ClassLoader.getSystemClassLoader().loadClass("com.example.reflect.TargetObject");
        /**
         * 通过类加载器获取Class对象不会进行初始化，意味着不进行包括初始化等一系列步骤，静态块和静态对象不会得到执行
         */
        System.out.println("over");
    }
}
