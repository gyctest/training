package com.traning1ch1.test;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/22 0022
 */
public class VolatileTest4 {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    private static volatile int num = 0;


    private static class TestThread extends Thread {


        private final VolatileTest4 volatileTest4;

        public TestThread(VolatileTest4 volatileTest4) {
            this.volatileTest4 = volatileTest4;

        }

        @Override
        public void run() {
            countDownLatch.countDown();
            num++;
            System.out.println(Thread.currentThread().getName() + ",add=" + num);
            num--;
            System.out.println(Thread.currentThread().getName() + ",--=" + num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest4 volatileTest4 = new VolatileTest4();
        for (int i = 0; i < 10; i++) {
            TestThread testThread = new TestThread(volatileTest4);
            testThread.start();

        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + ",开始执行");
        System.out.println(num);
    }
}
