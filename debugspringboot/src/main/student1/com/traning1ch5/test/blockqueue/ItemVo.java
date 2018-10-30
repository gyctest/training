package com.traning1ch5.test.blockqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/30 0030
 */
public class ItemVo<T> implements Delayed {

    /**
     * 数据
     */
    private T data;
    /**
     * 到期事件
     */
    private long activeTime;


    public ItemVo(T data, long timeoutMill) {
        this.data = data;
        this.activeTime = TimeUnit.NANOSECONDS.convert(timeoutMill, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.activeTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long d = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return (d == 0) ? 0 : ((d > 0) ? 1 : -1);
    }

    public T getData() {
        return data;
    }
}
