package com.traning1ch1.test;

import com.xiangxue.tools.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/23 0023
 */
public class ThreadLocalTest5 {

    public static CountDownLatch countDownLatch = new CountDownLatch(11);

    public ThreadLocal<Integer> local = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }

    };


    private static class TestLocalThread extends Thread {

        private final ThreadLocalTest5 testLocalThread;

        public TestLocalThread(ThreadLocalTest5 testLocalThread) {
            this.testLocalThread = testLocalThread;

        }


        @Override
        public void run() {
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ",before localvalue:" + testLocalThread.local.get());
            testLocalThread.local.set(testLocalThread.local.get() + 1);
            System.out.println(Thread.currentThread().getName() + ",after localvalue:" + testLocalThread.local.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest5 test = new ThreadLocalTest5();
        for (int i = 0; i < 10; i++) {
            TestLocalThread testLocalThread = new TestLocalThread(test);
            testLocalThread.start();
        }
        System.out.println(Thread.currentThread().getName() + "," + test.local);
        SleepTools.second(5);
        countDownLatch.countDown();
        System.out.println(Thread.currentThread().getName() + ",");
    }
}
