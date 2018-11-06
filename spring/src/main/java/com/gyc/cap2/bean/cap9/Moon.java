package com.gyc.cap2.bean.cap9;

import org.springframework.stereotype.Component;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/6 0006
 */
@Component
public class Moon {

    public Moon() {
        System.out.println("moon 构造函数...");
    }

    public void init() {
        System.out.println("moon init 方法....");
    }

    public void destory() {
        System.out.println("moon destory 方法....");
    }
}
