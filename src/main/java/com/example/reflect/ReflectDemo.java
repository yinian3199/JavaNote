package com.example.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lixiang
 * @date 2021/3/31 22:22
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /**
         * 获取TargetObject类的Class对象并且创建TargetObject类实例
         */
        Class<?> targetClass = Class.forName("com.example.reflect.TargetObject");
        TargetObject target = (TargetObject) targetClass.newInstance();

        /**
         * 获取类中定义的所有方法
         */
        Method[] methods = targetClass.getMethods();
        for (Method method: methods){
            System.out.println(method.getName());
        }

        /**
         * 指定方法并调用
         */
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod", String.class);
        publicMethod.invoke(target,"javaNote");

        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = targetClass.getDeclaredField("value");
//        为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(target,"update");

        /**
         * 调用private方法
         */
        Method privateMethod =targetClass.getDeclaredMethod("privateMethod");
//        为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(target);
    }
}
