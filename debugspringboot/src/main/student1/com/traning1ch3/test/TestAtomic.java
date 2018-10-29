package com.traning1ch3.test;

import com.xiangxue.ch3.AtomicArray;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/26 0026
 */
public class TestAtomic {
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger(10);
        System.out.println(atomicInteger.intValue());
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.getAndIncrement());

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{3,1,4,5,2});
        System.out.println(atomicIntegerArray.get(4));
        System.out.println(atomicIntegerArray.getAndIncrement(0));
        System.out.println(atomicIntegerArray.get(0));


    }
}
