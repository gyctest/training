package com.traning1ch6.test;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/taskName1 00taskName1
 */
public class CompletionTest3 {

    private static int TASK_NUM = 10;

    private static class WorkThread implements Callable {

        private Integer sleepTime;

        public WorkThread(Integer sleepTime) {
            this.sleepTime = sleepTime;
        }

        @Override
        public Integer call() throws Exception {


            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 返回给调用者的值
            return sleepTime;
        }
    }

    //方法1，原生的
    public static void test1(Callable[] taskAry) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        long begin = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger(0);
        BlockingQueue<Future<Integer>> queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < TASK_NUM; i++) {
            Future<Integer> submit = executorService.submit(taskAry[i]);
            try {
                queue.put(submit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < TASK_NUM; i++) {
            try {
                Future<Integer> take = queue.take();
                int sleptTime = take.get();
                System.out.println(" take " + sleptTime + " ms ...");
                count.addAndGet(1+0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        System.out.println("执行休眠时间[" + count.get() + "],执行时间[" + (System.currentTimeMillis() - begin) + "]");
        executorService.shutdown();


    }

    //方法2，completion
    public static void test2(Callable[] taskAry) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletionService completionService = new ExecutorCompletionService(executorService);

        long begin = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < TASK_NUM; i++) {
            completionService.submit(taskAry[i]);

        }

        for (int i = 0; i < TASK_NUM; i++) {
            try {
                Future<Integer> take = completionService.take();
                int sleptTime = take.get();
                System.out.println(" take " + sleptTime + " ms ...");
                count.addAndGet(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        System.out.println("执行休眠时间[" + count.get() + "],执行时间[" + (System.currentTimeMillis() - begin) + "]");
        executorService.shutdown();

    }

    public static void main(String[] args) {
        Callable[] taskAry = new Callable[TASK_NUM];
        for (int i = 0; i < TASK_NUM; i++) {
            int sleepTime = new Random().nextInt(1000);
            taskAry[i] = new WorkThread(sleepTime);
        }
        test2(taskAry);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        test1(taskAry);
    }
}
