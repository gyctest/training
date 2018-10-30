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
public class FetchOrder implements Runnable {

    DelayQueue<ItemVo<OrderVo>> delayQueue;

    public FetchOrder(DelayQueue<ItemVo<OrderVo>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ItemVo<OrderVo> take = delayQueue.take();
                OrderVo data = take.getData();
                System.out.println(data.getOrderNo() + ",超时退出..."+delayQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
