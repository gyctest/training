package com.traning1ch2.test.forkjoin1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/24 0024
 */
public class FindDirByForJoinsTest {

    private static class TestFor extends RecursiveAction {

        File path;

        public TestFor(File path) {
            this.path = path;
        }

        @Override
        protected void compute() {
            List<TestFor> subTasks = new ArrayList<>();

            if (path == null) {
                return;
            }
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        subTasks.add(new TestFor(file));
                    } else if (file.getName().endsWith("txt")) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
            if (!subTasks.isEmpty()) {
                Collection<TestFor> testFors = invokeAll(subTasks);
                for (TestFor testFor : testFors) {
                    testFor.join();
                }
            }
        }
    }

    /**
     * 递归方式处理
     *
     * @param file
     */
    public static void resive(File file) {
        if (file == null) {
            return;
        }
        File[] files = file.listFiles();
        if (files == null) {
            return;
        }
        for (File file1 : files) {
            if (file1.isDirectory()) {
                resive(file1);
            } else if (file1.getName().endsWith("txt")) {
                System.out.println(file1.getAbsolutePath());
            }
        }
    }

    public static void main1(String[] args) throws Exception {
        long begin = System.currentTimeMillis();
        File file = new File("E:\\project\\acs");
        TestFor task = new TestFor(file);

        ForkJoinPool pool = new ForkJoinPool();

        pool.execute(task);//异步调用

        System.out.println("Task is Running......");
        Thread.sleep(1);


        int otherWork = 0;
        for (int i = 0; i < 100; i++) {
            otherWork = otherWork + i;
        }
        System.out.println("Main Thread done sth......,otherWork=" + otherWork);


        task.join();//阻塞的方法
        System.out.println("Task end ,执行时间:" + (System.currentTimeMillis() - begin) + "ms.");
    }

    public static void main2(String[] args) {
        long begin = System.currentTimeMillis();
        File file = new File("E:\\project\\acs");
        resive(file);
        System.out.println("Task end ,执行时间:" + (System.currentTimeMillis() - begin) + "ms.");
    }

    public static void main(String[] args) throws Exception {
        main1(args);
    }
}
