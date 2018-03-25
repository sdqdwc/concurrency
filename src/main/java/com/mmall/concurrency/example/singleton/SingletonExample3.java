package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时创建
 * @author WangCH
 * @create 2018-03-21 18:21
 */
@ThreadSafe
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExample3 getInstance(){
        if(instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
