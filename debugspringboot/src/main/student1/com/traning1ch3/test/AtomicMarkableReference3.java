package com.traning1ch3.test;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/26 0026
 */
public class AtomicMarkableReference3 {
    public static void main(String[] args) {
        AtomicMarkableReference markableReference = new AtomicMarkableReference("gyc", true);
        System.out.println(markableReference.compareAndSet("gyc", "abc", false, true));
        System.out.println(markableReference.compareAndSet("gyc", "abc", true, true));

        AtomicStampedReference stampedReference = new AtomicStampedReference("gyc",1);
        System.out.println(stampedReference.compareAndSet("gyc", "abc", 2, 3));
        System.out.println(stampedReference.compareAndSet("gyc", "abc", 1, 3));
    }
}
