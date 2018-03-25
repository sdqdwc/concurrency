package com.mw.concurrency.example.threadLocal;

/**
 * @author WangCH
 * @create 2018-03-21 23:53
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
