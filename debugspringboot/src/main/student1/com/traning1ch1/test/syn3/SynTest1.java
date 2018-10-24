package com.traning1ch1.test.syn3;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/22 0022
 */
public class SynTest1 {
    private int age = 0;//初始100000

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public synchronized void test1() {
        age++;
    }

    public synchronized void test2() {
        age--;
    }

    private static class TestThread extends Thread {

        private final SynTest1 synTest;

        public TestThread(SynTest1 synTest) {
            this.synTest = synTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                this.synTest.test1();
            }
            System.out.println(Thread.currentThread().getName()
                    + " age =  " + synTest.getAge());
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SynTest1 synTest = new SynTest1();
        TestThread testThread = new TestThread(synTest);
        testThread.start();
//        testThread.join();

        System.out.println(Thread.currentThread().getName()
                + " age =  " + synTest.getAge());
        for (int i = 0; i < 1000000; i++) {
            synTest.test2();
        }
        System.out.println(Thread.currentThread().getName()
                + " age =  " + synTest.getAge());
    }
}
