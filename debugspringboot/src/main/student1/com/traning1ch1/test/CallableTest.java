package com.traning1ch1.test;

import com.xiangxue.tools.SleepTools;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/22 0022
 */
public class CallableTest {

    private static class TestCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            SleepTools.second(5);
            return 2;
        }
    }

    public static void main(String[] args) throws Exception {
        TestCallable testCallable = new TestCallable();

        FutureTask futureTask = new FutureTask(testCallable);

        Thread thread = new Thread(futureTask);
        thread.start();

        thread.interrupt();

        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName());
        SleepTools.second(2);
        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName());
        System.out.println(futureTask.get());
        System.out.println(System.currentTimeMillis() + " " + " callable 返回值获取");

    }
}
