package com.mmall.concurrency.example.singleton;


import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例的实例在类装载时创建
 * @author WangCH
 * @create 2018-03-21 18:21
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){

    }
    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
