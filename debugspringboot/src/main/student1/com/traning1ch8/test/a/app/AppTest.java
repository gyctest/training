package com.traning1ch8.test.a.app;

import com.traning1ch8.test.a.ITaskProcesser;
import com.traning1ch8.test.a.PendingJobPool;
import com.traning1ch8.test.a.vo.TaskResult;
import com.xiangxue.tools.SleepTools;

import java.util.List;
import java.util.Random;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/2 0002
 */
public class AppTest {

    private final static String JOB_NAME = "计算数值";
    private final static int JOB_LENGTH = 1000;

    private static class QueryResult implements Runnable {
        private PendingJobPool instance;

        public QueryResult(PendingJobPool instance) {
            this.instance = instance;
        }

        @Override
        public void run() {
            int i = 0;//查询次数
            while (i < 350) {
                List<TaskResult<String>> taskDetail = instance.getTaskDetail(JOB_NAME);
                if (!taskDetail.isEmpty()) {
                    System.out.println(instance.getTaskProgess(JOB_NAME));
                    System.out.println(taskDetail);
                }
                SleepTools.ms(100);
                i++;
            }
        }
    }

    public static void main(String[] args) {
        ITaskProcesser<?, ?> myTask = new MyTask();

        String jobName = "";
        int process;
        PendingJobPool instance = PendingJobPool.getInstance();
        instance.registJob(JOB_NAME, JOB_LENGTH, myTask, 5 * 1000);


        Random r = new Random();
        for (int i = 0; i < JOB_LENGTH; i++) {
            //依次推入Task
            instance.putTask(JOB_NAME, r.nextInt(1000));
        }

        Thread t = new Thread(new QueryResult(instance));
        t.start();
    }
}
