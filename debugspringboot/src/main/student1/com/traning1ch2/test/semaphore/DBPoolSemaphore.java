package com.traning1ch2.test.semaphore;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * 类说明：演示Semaphore用法，一个数据库连接池的实现
 */
public class DBPoolSemaphore {

    LinkedList<Connection> pool = new LinkedList<>();

    // useful 能够使用的数量   userLess 已经使用的数量
    private Semaphore useful, userLess;

    public DBPoolSemaphore(int initSize) {
        for (int i = 0; i < initSize; i++) {
            pool.addLast(new SqlConnectImpl());
        }
        useful = new Semaphore(pool.size());
        userLess = new Semaphore(0);
    }

    public Connection takeConnect() {
        try {
            useful.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        synchronized (pool) {
            long begin = System.currentTimeMillis();
            conn = pool.removeFirst();
        }

        userLess.release();

        return conn;
    }

    public void realseConn(Connection conn) {
        if (conn != null) {
            try {
                userLess.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (pool) {
                System.out.println("当前有" + useful.getQueueLength() + "个线程等待数据库连接！！"
                        + "可用连接数:" + useful.availablePermits() + ",已经使用连接:" + userLess.availablePermits());
                pool.addLast(conn);
            }
            useful.release();
        }
    }
}
