package com.mw.concurrency.example.immutable;

import com.mw.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangCH
 * @create 2018-03-21 21:45
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer,Integer> map =  new HashMap<>();

    static{
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        //final修饰引用数据类型，里面的值是可以修改的，只是不可以指向另外一个对象
        map.put(1,3);
        System.out.println(map.get(1));

    }


}
