package com.traning1ch1.test.syn3;

import com.xiangxue.tools.SleepTools;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/22 0022
 */
public class SynClzTest2 {

    private static class ClzClass extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "TestClass is running...");
            testClass();
        }


    }

    private static synchronized void testClass() {
        System.out.println(Thread.currentThread().getName() + "开始运行class锁...");
        SleepTools.ms(1000);
        System.out.println(Thread.currentThread().getName() + "运行class锁结束");
    }

    private static class InstanceClass extends Thread {

        private final SynClzTest2 synClzTest2;

        public InstanceClass(SynClzTest2 synClzTest2) {
            this.synClzTest2 = synClzTest2;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "InstanceClass is running...");
            synClzTest2.testInstance();
        }


    }

    private synchronized void testInstance() {
        System.out.println(Thread.currentThread().getName() + "开始运行instance锁...");
        SleepTools.ms(1000);
        System.out.println(Thread.currentThread().getName() + "运行instance锁结束");
    }


    public static void main(String[] args) {
        ClzClass clzClass = new ClzClass();
        ClzClass clzClass2 = new ClzClass();
        SynClzTest2 synClzTest2 = new SynClzTest2();

        InstanceClass instanceClass = new InstanceClass(synClzTest2);
        InstanceClass instanceClass2 = new InstanceClass(synClzTest2);

//        clzClass.start();
//        clzClass2.start();
//        instanceClass.start();
//        instanceClass2.start();
        System.out.println(Thread.currentThread().getName() + ",结束");

        for (int i = 0; i < 10; i++) {
//            new InstanceClass(synClzTest2).start();
            new ClzClass().start();
        }
    }
}
