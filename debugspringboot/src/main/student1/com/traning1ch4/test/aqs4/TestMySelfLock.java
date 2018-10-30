package com.traning1ch4.test.aqs4;

import com.xiangxue.ch4.aqs.SelfLock;
import com.xiangxue.tools.SleepTools;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/29 0029
 */
public class TestMySelfLock {
    final static Lock lock = new SelfLock();

    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    SleepTools.second(1);
                    System.out.println(Thread.currentThread().getName());
                    SleepTools.second(1);
                } finally {
                    lock.unlock();
                }
                SleepTools.second(2);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        // 主线程每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepTools.second(1);
            System.out.println();
        }
    }

}
