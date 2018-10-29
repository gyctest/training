package com.traning1ch2.test.semaphore;

import com.xiangxue.tools.SleepTools;

import java.sql.Connection;
import java.util.Random;

/**
 * 类说明：测试数据库连接池
 */
public class AppTest {

    private static class TestThread implements Runnable {

        DBPoolSemaphore dbPoolSemaphore;

        public TestThread(DBPoolSemaphore dbPoolSemaphore) {
            this.dbPoolSemaphore = dbPoolSemaphore;
        }

        @Override
        public void run() {
            long begin = System.currentTimeMillis();
            Connection connection = dbPoolSemaphore.takeConnect();
            System.out.println(Thread.currentThread().getName() + ",获取连接时间:" + (System.currentTimeMillis() - begin) + "ms");
            SleepTools.second(new Random().nextInt(5));
            dbPoolSemaphore.realseConn(connection);
        }
    }

    public static void main(String[] args) {
        DBPoolSemaphore dbPoolSemaphore = new DBPoolSemaphore(10);

        for (int i = 0; i < 50; i++) {
            new Thread(new TestThread(dbPoolSemaphore)).start();
        }
        System.out.println(Thread.currentThread().getName() + " over");
    }
}
