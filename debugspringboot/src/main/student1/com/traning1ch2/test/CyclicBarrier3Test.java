package com.traning1ch2.test;

import com.xiangxue.tools.SleepTools;

import java.util.concurrent.CyclicBarrier;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/25 0025
 */
public class CyclicBarrier3Test {

    private static CyclicBarrier cyclicBarrier;

    static {
        cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ",接收任务");
            }
        });
    }

    private static class TestThread extends Thread {
        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new TestThread().start();
            SleepTools.second(1);
        }
    }
}
