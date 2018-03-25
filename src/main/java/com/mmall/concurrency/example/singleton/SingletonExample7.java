package com.mmall.concurrency.example.singleton;

import com.mmall.concurrency.annotations.Recommend;
import com.mmall.concurrency.annotations.ThreadSafe;

/**
 * 枚举模式:最安全
 * @author WangCH
 * @create 2018-03-21 21:23
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{

        INSTANCE;

        private SingletonExample7 singletonExample7;

        //JVM保证绝对只被调用1次
        Singleton(){
            singletonExample7 = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singletonExample7;
        }
    }
}
