package com.gyc.cap2.bean.cap7;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class Train implements InitializingBean,DisposableBean {
    public Train() {
        System.out.println("train 构造函数..............");
    }

    public void destroy() throws Exception {
        System.out.println("train destroy..............");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("train afterPropertiesSet..............");
    }
}
