package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author WangCH
 * @create 2018-03-21 16:44
 */
@Slf4j
public class SynchronizedExample1 {

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
            for(int i=0;i<10;i++){
                log.info("test1 {}-{}",j,i);
            }
        }
    }
    //修饰一个方法
    public synchronized  void test2(int j){
        for(int i=0;i<10;i++){
            log.info("test2 {}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            example1.test2(1);
        });
        service.execute(()->{
            example2.test2(2);
        });
    }

}
