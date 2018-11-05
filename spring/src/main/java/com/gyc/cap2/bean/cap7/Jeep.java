package com.gyc.cap2.bean.cap7;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
@Component
public class Jeep {
    public Jeep() {
        System.out.println("jeep 构造函数.................");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct 调用........");
    }

    @PreDestroy
    public void destory() {
        System.out.println(" @PreDestroy 调用........");
    }
}
