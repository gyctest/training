package com.traning1ch8.test.a.vo;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/2 0002
 */
public class TaskResult<R> {

    private final TaskResultType taskResultType;
    private final R data;
    private final String msg;

    public TaskResult(TaskResultType taskResultType, R data, String msg) {
        this.taskResultType = taskResultType;
        this.data = data;
        this.msg = msg;
    }

    public TaskResult(TaskResultType taskResultType, R data) {
        this.taskResultType = taskResultType;
        this.data = data;
        this.msg = null;
    }


    public TaskResultType getTaskResultType() {
        return taskResultType;
    }

    public R getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }
}
