package com.traning1ch2.test.forkjoin1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/25 0025
 */
public class ArrayRecursiveTaskTest {

    private static class ArrayRecursiveTask extends RecursiveTask<Integer> {
        private int[] array;
        private int fromIdx;
        private int toIdx;
        private int fz;

        public ArrayRecursiveTask(int[] array, int fromIdx, int toIdx, int fz) {
            this.array = array;
            this.fromIdx = fromIdx;
            this.toIdx = toIdx;
            this.fz = fz;
        }


        @Override
        protected Integer compute() {
            if (toIdx - fromIdx <= fz) {
                int sum = 0;
                for (int i = fromIdx; i <= toIdx; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int mid = (fromIdx + toIdx) / 2;
                ArrayRecursiveTask left = new ArrayRecursiveTask(array, fromIdx, mid, fz);
                ArrayRecursiveTask right = new ArrayRecursiveTask(array, mid + 1, toIdx, fz);
                invokeAll(left, right);
                return left.join() + right.join();

            }


        }
    }


    public static int sum(int[] ary) {
        int total = 0;
        for (int i = 0; i < ary.length; i++) {
            total += ary[i];
        }
        return total;
    }

    public static void main(String[] args) {


        int[] ary = new int[1000];
        for (int i = 0; i < 1000; i++) {
            ary[i] = i + 1;
        }
        long aa = System.currentTimeMillis();
        System.out.println(sum(ary) + ",for循环计算:" + (System.currentTimeMillis() - aa) + "ms.");
        long beginTime = System.currentTimeMillis();
        ArrayRecursiveTask test = new ArrayRecursiveTask(ary, 0, ary.length - 1, 10);

        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(test);

        Integer join = test.join();
        System.out.println(join + "]:Task end ,执行时间:" + (System.currentTimeMillis() - beginTime) + "ms.");
    }
}
