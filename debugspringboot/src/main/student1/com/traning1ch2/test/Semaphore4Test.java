package com.traning1ch2.test;

import com.xiangxue.tools.SleepTools;

import java.util.concurrent.Semaphore;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/26 0026
 */
public class Semaphore4Test {

    private static class TestThread implements Runnable {
        private Semaphore semaphore;

        public TestThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                long begin = System.currentTimeMillis();
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "，获取到资源获取时间:" + (System.currentTimeMillis() - begin) + "ms,当前队列:" + semaphore.getQueueLength());
                SleepTools.second(2);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < 20; i++) {
            TestThread testThread = new TestThread(semaphore);

            new Thread(testThread).start();
        }

    }
}

