package com.mw.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author WangCH
 * @create 2018-03-23 15:09
 */
@Slf4j
public class SemaphoreExample1 {

    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for(int i=0;i<threadCount;i++){
            final int threadNum = i;
            exec.execute(()->{
                try {
                    if(semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){//尝试获取一个许可，获取到了允许执行，否则不执行
                        test(threadNum);
                        semaphore.release();
                    }
                  //  semaphore.acquire(); //获取一个许可
                  //  test(threadNum);
                  //  semaphore.release();//释放一个许可
                }catch (Exception e){
                    log.error("exception", e);
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
