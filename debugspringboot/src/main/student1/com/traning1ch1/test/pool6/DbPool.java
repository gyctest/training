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
    private LinkedList<Connection> pools = new LinkedList<>();


    public DbPool(int initalSize) {
        if (initalSize > 0) {
            for (int i = 0; i < initalSize; i++) {
                Connection connect = new SqlConnectionImpl();
                pools.addLast(connect);
            }
        }

    }

    public synchronized Connection getConnection(long mills) throws InterruptedException {

        synchronized (pools) {
            if (mills <= 0) {
                if (pools.isEmpty()) {
                    pools.wait();
                }
                return pools.removeFirst();
            } else {
                long overtime = System.currentTimeMillis() + mills;
                long retains = mills;
                while (pools.isEmpty() && retains > 0) {
                    pools.wait(retains);
                    retains = overtime - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pools.isEmpty()) {
                    result = pools.removeFirst();
                }
                return result;
            }
        }

    }

    public void relaseConn(Connection conn) {

        if (conn != null) {
            synchronized (pools) {
                pools.addLast(conn);
                pools.notify();
            }
        }
    }
}
