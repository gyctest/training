package com.gyc.cap2.aop;

import org.springframework.stereotype.Component;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/6
 */
@Component
public class Calculator {

    public int div(int a, int b) {
        System.out.println("div方法执行");
        return a / b;
    }
}
