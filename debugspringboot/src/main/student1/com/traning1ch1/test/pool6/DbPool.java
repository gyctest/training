package com.traning1ch1.test.pool6;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/23 0023
 */
public class DbPool {
    private static LinkedList<Connection> pool = new LinkedList<>();


    public DbPool(int initalSize) {
        if (initalSize > 0) {
            for (int i = 0; i < initalSize; i++) {
                Connection connect = new SqlConnectImpl();
                pool.addLast(connect);
            }
        }

    }

    public  Connection getConnection(long mills) throws InterruptedException {

        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long overtime = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain > 0) {
                    pool.wait(remain);
                    remain = overtime - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }

    }

    public void relaseConn(Connection conn) {

        if (conn != null) {
            synchronized (pool) {
                pool.addLast(conn);
                pool.notify();
            }
        }
    }
}
