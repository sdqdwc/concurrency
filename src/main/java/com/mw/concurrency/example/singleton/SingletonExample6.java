package com.mw.concurrency.example.singleton;


import com.mw.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例的实例在类装载时创建
 * @author WangCH
 * @create 2018-03-21 18:21
 */
@ThreadSafe
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6(){

    }
    //单例对象
    private static SingletonExample6 instance = null;

    static{
        instance = new SingletonExample6();
    }

    //静态的工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}