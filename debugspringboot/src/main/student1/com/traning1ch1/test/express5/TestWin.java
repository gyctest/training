package com.traning1ch1.test.express5;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/23 0023
 */
public class TestWin {

    private static class CheckKmThread extends Thread {
        Express express;

        public CheckKmThread(Express express) {
            this.express = express;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ",等待里程通知");
            this.express.waiteKm();
        }
    }

    private static class CheckSiteThread extends Thread {
        Express express;

        public CheckSiteThread(Express express) {
            this.express = express;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ",等待city通知");
            this.express.waiteCity();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Express express = new Express(100, "Xian");

        for (int i = 0; i < 3; i++) {
            CheckKmThread checkKmThread = new CheckKmThread(express);
            checkKmThread.setDaemon(true);
            checkKmThread.start();
        }

        for (int i = 0; i < 3; i++) {
            CheckSiteThread checkKmThread = new CheckSiteThread(express);
            checkKmThread.setDaemon(true);
            checkKmThread.start();
        }
        Thread.sleep(5000);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        express.changeCity();
        express.changeKm();


        express.changeKm();


    }
}
