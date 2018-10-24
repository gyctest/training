package com.traning1ch1.test.pool6;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/23 0023
 */
public class TestDbPool {

    private static final int NUM = 50;
    private static CountDownLatch countDownLatch = new CountDownLatch(NUM);


    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        int count = 20;//每个线程的操作次数
        DbPool pool = new DbPool(10);
        AtomicInteger user = new AtomicInteger(0);
        AtomicInteger wait = new AtomicInteger(0);
        for (int i = 0; i < NUM; i++) {
            TestThread testThread = new TestThread(pool, count, user, wait);
            testThread.start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + ",执行时间:" + (System.currentTimeMillis() - begin) + "ms");
        System.out.println(Thread.currentThread().getName() + ",获取所数量:" + user.intValue());
        System.out.println(Thread.currentThread().getName() + ",没有获取连接的数量:" + wait.intValue());
    }


    private static class TestThread extends Thread {

        private final DbPool pool;
        private final AtomicInteger userInteger;
        private final AtomicInteger notInteger;
        private int count;

        public TestThread(DbPool conn, int count, AtomicInteger userInteger, AtomicInteger notInteger) {
            this.pool = conn;
            this.userInteger = userInteger;
            this.notInteger = notInteger;
            this.count = count;
        }

        @Override
        public void run() {
            while (count > 0) {
                Connection connection = null;
                try {
                    long begin = System.currentTimeMillis();
                    connection = pool.getConnection(1000);
                    if (connection != null) {
                        try {
                            Statement statement = connection.createStatement();
                            int idx = userInteger.incrementAndGet();
                            connection.commit();
                            System.out.println(Thread.currentThread().getName() + ",获取连接信息时间：" + (System.currentTimeMillis() - begin) + "ms,顺序:" + idx);
                        } finally {
                            pool.relaseConn(connection);
                        }
                    } else {
                        int idx = notInteger.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + ",超时时间：" + (System.currentTimeMillis() - begin) + "ms,顺序:" + idx);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    count--;
                }
            }
            countDownLatch.countDown();
        }
    }


}
