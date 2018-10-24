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

    public static void main(String[] args) throws Exception {
        File file = new File("F:\\");
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
        System.out.println("Task end");

    }
}
