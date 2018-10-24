package com.traning1ch1.test;

import com.xiangxue.tools.SleepTools;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/22 0022
 */
public class InterruptTest2 {

    private static final String PATTERN = "yyyyMMdd HH:mm:ss";

    private static class Test extends Thread {


        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println("data:" + DateFormatUtils.format(new Date(), PATTERN) + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //安全终端
                    interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName()
                    + " interrupt flag is " + isInterrupted());
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();

        SleepTools.second(2);

        test.interrupt();
    }
}
