package com.traning1ch4.test;

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
public class LockDemo1 {

    private Lock lock = new ReentrantLock();
    private int num;

    private void add() {
        lock.lock();
        try {
            num = num + 1;
        } finally {
            lock.unlock();
        }
    }

    public int getNum() {
        return num;
    }


    private static class TestThread extends Thread {
        private LockDemo1 lockDemo1;

        public TestThread(LockDemo1 lockDemo1) {
            this.lockDemo1 = lockDemo1;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ",开始执行..,num=" + lockDemo1.getNum());
            lockDemo1.add();
            System.out.println(Thread.currentThread().getName() + ",执行结束..,num=" + lockDemo1.getNum());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockDemo1 lockDemo1 = new LockDemo1();
        for (int i = 0; i < 100; i++) {
            new TestThread(lockDemo1).start();
        }
//        Thread.currentThread().join();
        System.out.println(lockDemo1.getNum());
    }
}
