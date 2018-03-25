package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;


/**
 * @author WangCH
 * @create 2018-03-22 15:15
 */
@Slf4j
@NotThreadSafe
public class VectorExample2 {

    public static Vector<Integer> vector = new Vector();

    public static void main(String[] args) throws InterruptedException {

        while(true){
            for(int i=0;i<10;i++){
                vector.add(i);
            }
            Thread thread1 = new Thread(){
                public void run(){
                    for(int i=0;i<vector.size();i++){
                        vector.remove(i);
                    }
                }
            };
            Thread thread2 = new Thread(){
                public void run(){
                    for(int i=0;i<vector.size();i++){
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }

}
