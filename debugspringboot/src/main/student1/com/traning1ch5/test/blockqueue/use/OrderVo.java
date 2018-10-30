package com.traning1ch5.test.blockqueue.use;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/30 0030
 */
public class OrderVo {
    private String orderNo;
    private double money;

    public OrderVo(String orderNo, double money) {
        this.orderNo = orderNo;
        this.money = money;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
