package com.traning1ch2.test;

import com.xiangxue.tools.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/25 0025
 */
public class CountDownLatch2Test {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    private static class TestThread extends Thread {
        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName());
            SleepTools.second(2);
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new TestThread().start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName());
    }
}
