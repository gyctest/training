package com.traning1ch1.test;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/24 0024
 */
public class JoinTest7 {

    private static class TestThread extends Thread {
        private final Thread before;

        public TestThread(Thread before) {
            this.before = before;
        }

        @Override
        public void run() {

            try {
                before.join();
                System.out.println(before.getName() + ",执行完成后-->>执行" + Thread.currentThread().getName() + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Thread before = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            TestThread testThread = new TestThread(before);
            before = testThread;
            testThread.start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
