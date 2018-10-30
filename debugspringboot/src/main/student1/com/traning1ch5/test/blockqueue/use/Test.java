package com.traning1ch5.test.blockqueue.use;

import com.traning1ch5.test.blockqueue.ItemVo;

import java.util.concurrent.DelayQueue;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/30 0030
 */
public class Test {

    public static void main(String[] args) {

        DelayQueue<ItemVo<OrderVo>> delayQueue = new DelayQueue<>();

        new Thread(new PutOrder(delayQueue)).start();
        new Thread(new FetchOrder(delayQueue)).start();


    }
}
