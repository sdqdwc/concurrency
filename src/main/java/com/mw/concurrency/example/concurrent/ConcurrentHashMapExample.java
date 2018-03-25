package com.mw.concurrency.example.concurrent;

import com.mw.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author WangCH
 * @create 2018-03-22 14:46
 */
@Slf4j
@ThreadSafe
public class ConcurrentHashMapExample {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;
    //计数
    public static Map<Integer,Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            final int count = i;
            service.execute(() ->{
                try{
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                }catch (Exception e){
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("list:{}", map.size());
    }

    private static void update(int i){
        map.put(i,i);
    }
}
