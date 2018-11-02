package com.traning1ch8.test.a.vo;

import com.traning1ch8.test.a.ITaskProcesser;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/2 0002
 */
public class JobInfo<R> {
    //区分唯一的工作
    private final String jobName;
    //工作的任务个数
    private final int jobLength;
    //这个工作的任务处理器
    private final ITaskProcesser<?, ?> taskProcesser;
    //成功处理的任务数
    private final AtomicInteger successCount;
    //已处理的任务数
    private final AtomicInteger taskProcesserCount;
    //结果队列，拿结果从头拿，放结果从尾部放
    private final LinkedBlockingDeque<TaskResult<R>> taskDetailQueue;
    //工作的完成保存的时间，超过这个时间从缓存中清除
    private final long expireTime;

    public JobInfo(String jobName, int jobLength, ITaskProcesser<?, ?> taskProcesser, long expireTime) {
        this.jobName = jobName;
        this.jobLength = jobLength;
        this.taskProcesser = taskProcesser;
        this.successCount = new AtomicInteger(0);
        this.taskProcesserCount = new AtomicInteger(0);
        this.taskDetailQueue = new LinkedBlockingDeque<>();
        this.expireTime = expireTime;
    }

    public ITaskProcesser<?, ?> getTaskProcesser() {
        return taskProcesser;
    }

    //返回成功处理的结果数
    public int getSuccessCount() {
        return successCount.get();
    }

    //返回当前已处理的结果数
    public int getTaskProcesserCount() {
        return taskProcesserCount.get();
    }

    //提供工作中失败的次数，课堂上没有加，只是为了方便调用者使用
    public int getFailCount() {
        return taskProcesserCount.get() - successCount.get();
    }

    public String getTotalProcess() {
        return "Success[" + successCount.get() + "]/Current["
                + taskProcesserCount.get() + "] Total[" + jobLength + "]";
    }


    public void addTaskResult(TaskResult<R> result) {
        if (TaskResultType.Success.equals(result.getTaskResultType())) {
            successCount.incrementAndGet();
        }
        taskDetailQueue.addLast(result);
        taskProcesserCount.incrementAndGet();
    }

    public <R> List<TaskResult<R>> getTaskDetail() {
        List<TaskResult<R>> taskList = new LinkedList<>();
//        TaskResult<R> taskResult;
        //从阻塞队列中拿任务的结果，反复取，一直取到null为止，说明目前队列中最新的任务结果已经取完，可以不取了
        TaskResult<R> taskResult;
        while ((taskResult = (TaskResult<R>) taskDetailQueue.pollFirst()) != null) {
            taskList.add(taskResult);
        }
        return taskList;
    }
}
