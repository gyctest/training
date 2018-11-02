package com.traning1ch8.test.a.app;

import com.traning1ch8.test.a.ITaskProcesser;
import com.traning1ch8.test.a.vo.TaskResult;
import com.traning1ch8.test.a.vo.TaskResultType;
import com.xiangxue.tools.SleepTools;

import java.util.Random;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/2 0002
 */
public class MyTask implements ITaskProcesser<Integer, Integer> {

    @Override
    public TaskResult<Integer> taskExecute(Integer data) {
        Random r = new Random();
        int flag = r.nextInt(500);
        SleepTools.ms(flag);
        if (flag <= 300) {//正常处理的情况
            Integer returnValue = data.intValue() + flag;
            return new TaskResult<Integer>(TaskResultType.Success, returnValue);
        } else if (flag > 301 && flag <= 400) {//处理失败的情况
            return new TaskResult<Integer>(TaskResultType.Fail, -1, "Failure");
        } else {//发生异常的情况
            try {
                throw new RuntimeException("异常发生了！！");
            } catch (Exception e) {
                return new TaskResult<Integer>(TaskResultType.Exception,
                        -1, e.getMessage());
            }
        }
    }
}
