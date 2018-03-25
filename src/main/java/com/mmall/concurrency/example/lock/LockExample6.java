package com.mmall.concurrency.example.lock;

import com.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * @author WangCH
 * @create 2018-03-21 14:52
 */
@Slf4j
@ThreadSafe
public class LockExample6 {

    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() ->{
            try{
                reentrantLock.lock();
                log.info("wait signal");//1
                condition.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            log.info("get signal");//4
            reentrantLock.unlock();
        }).start();

        new Thread(() ->{
            try{
                reentrantLock.lock();
                log.info("get lock");//2
            }catch (Exception e){
                e.printStackTrace();
            }
            condition.signal();
            //condition.signalAll();
            log.info("send signal ~");//3
            reentrantLock.unlock();
        }).start();

    }



}
