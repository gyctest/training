package com.traning1ch6.test.mypool1;

import java.util.Random;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/31 0031
 */
public class TestMyPools {

    private static class TaskThread implements Runnable {

        private String name;

        public TaskThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                Random r = new Random();
                Thread.sleep(r.nextInt(1000)+2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                        +Thread.currentThread().isInterrupted());
            }
            System.out.println("任务 " + name + " 完成");
        }
    }

    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(10, 2);

        for (int i = 0; i < 10; i++) {
            myThreadPool.execute(new TaskThread("test" + i));
        }


//        myThreadPool.destory();
    }

}
