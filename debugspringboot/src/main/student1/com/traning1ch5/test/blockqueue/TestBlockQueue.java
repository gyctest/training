package com.traning1ch5.test.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/30 0030
 */
public class TestBlockQueue {
    public static void main(String[] args){
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            String name = "test"+i;
            try {
                abq.put(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(abq);
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>();
        for (int i = 0; i < 11; i++) {
            String name = "test"+i;
            try {
                lbq.put(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(lbq);
    }
}
