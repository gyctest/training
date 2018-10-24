package com.traning1ch1.test.express5;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/23 0023
 */
public class Express {

    public final static String CITY = "ShangHai";
    private int km;/*快递运输里程数*/
    private String site;/*快递到达地点*/

    public Express(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeKm() {
        km = 101;
        System.out.println(Thread.currentThread().getName() + ",线程改变里程:" + km);
        notifyAll();

    }

    public synchronized void changeCity() {

        site = CITY;
        System.out.println(Thread.currentThread().getName() + ",线程改变城市:" + site);
        notifyAll();
    }

    public synchronized void waiteKm() {
        while (km <= 100) {
            try {
                this.wait();
                System.out.println("check km thread[" + Thread.currentThread().getName()
                        + "] is be notifed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ",里程数据改变了，存放数据库");
    }

    public synchronized void waiteCity() {
        while (CITY.equalsIgnoreCase(site)) {
            try {
                this.wait();
                System.out.println("check 城市 thread[" + Thread.currentThread().getName()
                        + "] is be notifed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ",city数据改变了，存放数据库");
    }


}
