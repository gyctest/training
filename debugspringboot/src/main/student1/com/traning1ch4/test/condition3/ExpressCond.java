package com.traning1ch4.test.condition3;

import java.util.concurrent.locks.Condition;
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
public class ExpressCond {


    public final static String CITY = "ShangHai";
    private int km;/*快递运输里程数*/
    private String site;/*快递到达地点*/

    private Lock lock = new ReentrantLock();
    private Condition siteCondition = lock.newCondition();
    private Condition kmCondition = lock.newCondition();

    public ExpressCond(int km, String site) {
        this.km = km;
        this.site = site;

    }

    public synchronized void changeKm() {
        lock.lock();
        try {
            km = 101;
            System.out.println(Thread.currentThread().getName() + ",线程改变里程:" + km);
            kmCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void changeCity() {
        lock.lock();
        try {
            site = CITY;
            System.out.println(Thread.currentThread().getName() + ",线程改变城市:" + site);
            siteCondition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public void waiteKm() {
        lock.lock();
        try {
            while(this.km<=100) {
                try {
                    kmCondition.await();
                    System.out.println("check km thread["+Thread.currentThread().getId()
                            +"] is be notifed.");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void waiteCity() {
        lock.lock();
        try {
            while(CITY.equals(this.site)) {
                try {
                    siteCondition.await();
                    System.out.println("check site thread["+Thread.currentThread().getId()
                            +"] is be notifed.");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }

    }


}
