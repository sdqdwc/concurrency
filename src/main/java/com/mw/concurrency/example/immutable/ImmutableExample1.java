package com.mw.concurrency.example.immutable;

import com.mw.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangCH
 * @create 2018-03-21 21:45
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    //private final static Map<Integer,Integer> map = Maps.newHashMap();
    private final static Map<Integer,Integer> map =  new HashMap<>();

    static{
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        //a = 2;
        //b = "sd";
        //map = new HashMap<>();

        //final修饰引用数据类型，里面的值是可以修改的，只是不可以指向另外一个对象
        map.put(1,3);
        System.out.println(map.get(1));

    }

    private void test(final int a){
       // a = 1;
    }
}
