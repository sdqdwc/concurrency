package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时创建
 * @author WangCH
 * @create 2018-03-21 18:21
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){

    }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态的工厂方法
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
