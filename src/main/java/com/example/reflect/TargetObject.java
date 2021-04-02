package com.example.reflect;

/**
 * @author lixiang
 * @date 2021/3/31 22:19
 */
public class TargetObject {

    private String value;

    public TargetObject(){
        value = "javaNote";
    }

    public void publicMethod(String s){
        System.out.println("public "+s);
    }

    private void privateMethod(){
        System.out.println("value = "+value);
    }

}
