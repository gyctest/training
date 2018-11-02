package com.traning1ch8.test.a;

import com.traning1ch8.test.a.vo.JobInfo;
import com.traning1ch8.test.a.vo.TaskResult;
import com.traning1ch8.test.a.vo.TaskResultType;

import java.util.List;
import java.util.concurrent.*;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/2 0002
 */
public class PendingJobPool {
    //保守估计
    private static final int THREAD_COUNTS =
            Runtime.getRuntime().availableProcessors();
    //任务队列
    private static BlockingQueue<Runnable> taskQueue
            = new ArrayBlockingQueue<>(5000);
    //线程池，固定大小，有界队列
    private static ExecutorService taskExecutor =
            new ThreadPoolExecutor(THREAD_COUNTS, THREAD_COUNTS, 60,
                    TimeUnit.SECONDS, taskQueue);
    //job的存放容器
    private static ConcurrentHashMap<String, JobInfo<?>> jobInfoMap
            = new ConcurrentHashMap<>();


    private PendingJobPool() {
    }

    public <R> List<TaskResult<R>> getTaskDetail(String jobName) {
        JobInfo<?> jobInfo = jobInfoMap.get(jobName);

        return jobInfo.getTaskDetail();
    }


    private static class PendingJobHandler {
        private static final PendingJobPool instance = new PendingJobPool();
    }

    public static PendingJobPool getInstance() {
        return PendingJobHandler.instance;
    }


    private static class TaskThread<T, R> implements Runnable {

        private JobInfo jobInfo;
        private T data;

        public TaskThread(JobInfo<R> jobInfo, T data) {
            this.jobInfo = jobInfo;
            this.data = data;
        }

        @Override
        public void run() {
            TaskResult result = null;
            R r = null;
            try {
                result = jobInfo.getTaskProcesser().taskExecute(data);
                //要做检查，防止开发人员处理不当
                if (result == null) {
                    result = new TaskResult<R>(TaskResultType.Exception, r,
                            "result is null");
                }
                if (result.getMsg() == null) {
                    if (result.getMsg() == null) {
                        result = new TaskResult<R>(TaskResultType.Exception, r, "reason is null");
                    } else {
                        result = new TaskResult<R>(TaskResultType.Exception, r,
                                "result is null,but reason:" + result.getMsg());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = new TaskResult<R>(TaskResultType.Exception, r,
                        e.getMessage());
            } finally {
                jobInfo.addTaskResult(result);
            }
        }
    }

    public <R> void registJob(String jobName, int jobLength, ITaskProcesser<?, ?> taskProcesser, long expireTime) {
        JobInfo<R> job = new JobInfo(jobName, jobLength, taskProcesser, expireTime);
        if (jobInfoMap.putIfAbsent(jobName, job) != null) {
            throw new RuntimeException("该job[" + jobName + "]已经存在");
        }
    }

    public <T, R> void putTask(String jobName, T t) {
        JobInfo<?> jobInfo = jobInfoMap.get(jobName);
        taskExecutor.execute(new TaskThread<>(jobInfo, t));
    }

    public String getTaskProgess(String jobName) {
        JobInfo jobInfo = jobInfoMap.get(jobName);
        return jobInfo.getTotalProcess();
    }
}
