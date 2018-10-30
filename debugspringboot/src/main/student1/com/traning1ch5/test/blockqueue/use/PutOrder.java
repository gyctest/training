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
public class PutOrder implements Runnable {

    DelayQueue<ItemVo<OrderVo>> delayQueue;

    public PutOrder(DelayQueue<ItemVo<OrderVo>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        OrderVo orderVo = new OrderVo("no5s", 10d);
        ItemVo<OrderVo> itemVo = new ItemVo<>(orderVo, 5000);
        delayQueue.offer(itemVo);
        System.out.println("5s超时订单放入成功..." + orderVo.getOrderNo());


        OrderVo orderVo2 = new OrderVo("no8s", 10d);
        ItemVo<OrderVo> itemVo2 = new ItemVo<>(orderVo2, 8000);
        delayQueue.offer(itemVo2);
        System.out.println("8s超时订单放入成功..." + orderVo2.getOrderNo());

    }
}
