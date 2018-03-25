package com.mmall.concurrency.example.publish;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author WangCH
 * @create 2018-03-21 18:09
 */
@Slf4j
@NotThreadSafe
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{

        public InnerClass(){
            log.info("{}",Escape.this.thisCanBeEscape);
        }

    }

    public static void main(String[] args) {
        new Escape();
    }
}
