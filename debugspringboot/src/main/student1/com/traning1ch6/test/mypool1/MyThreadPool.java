package com.traning1ch6.test.mypool1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/31 0031
 */
public class MyThreadPool {

    // 线程池中默认线程的个数为5
    private static int WORK_NUM = 5;
    // 队列默认任务个数为100
    private static int TASK_COUNT = 100;

    // 任务队列，作为一个缓冲
    private final BlockingQueue<Runnable> taskQueue;
    private final int workNum;//用户在构造这个池，希望的启动的线程数

    private final WorkThread[] workThreads;

    public MyThreadPool(int workNum, int taskNum) {
        if (workNum < 0) {
            this.workNum = WORK_NUM;
        } else {
            this.workNum = workNum;
        }
        if (taskNum < 0) {
            taskNum = TASK_COUNT;
        }
        taskQueue = new ArrayBlockingQueue<>(taskNum);
        workThreads = new WorkThread[this.workNum];
        for (int i = 0; i < this.workNum; i++) {
            workThreads[i] = new WorkThread(taskQueue);
            workThreads[i].start();
        }
    }

    public void execute(Runnable task){
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destory(){
        for (WorkThread workThread : workThreads) {
            workThread.shutdown();
        }
        taskQueue.clear();
    }

    private static class WorkThread extends Thread {
        BlockingQueue<Runnable> blockingQueue;

        public WorkThread(BlockingQueue<Runnable> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Runnable taskRunnable = blockingQueue.take();
                    if (taskRunnable != null) {
                        System.out.println(getId() + "  ready exec task " + taskRunnable);
                        taskRunnable.run();
                    }
                    taskRunnable = null;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutdown() {
            interrupt();
        }
    }

}
