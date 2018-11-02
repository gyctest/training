package com.traning1ch8.test.a;

import com.traning1ch8.test.a.vo.TaskResult;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/2 0002
 */
public interface ITaskProcesser<T, R> {

    public TaskResult<R> taskExecute(T data);
}
