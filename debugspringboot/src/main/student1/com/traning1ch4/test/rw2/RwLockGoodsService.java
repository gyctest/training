package com.traning1ch4.test.rw2;

import com.xiangxue.tools.SleepTools;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/29 0029
 */
public class RwLockGoodsService implements GoodsService {
    private GoodsInfo goodsInfo;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readlock = lock.readLock();
    private final Lock writelock = lock.readLock();

    public RwLockGoodsService(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public GoodsInfo getNum() {
        readlock.lock();
        try {
            SleepTools.ms(5);
        }finally {
            readlock.unlock();
        }
        return goodsInfo;
    }

    @Override
    public  void setNum(int number) {
        writelock.lock();
        try {
            SleepTools.ms(5);
            goodsInfo.changeNumber(number);
        }finally {
            writelock.unlock();
        }
    }
}
