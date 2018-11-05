package com.gyc.cap2.bean.cap7;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
@Component
public class Plane implements ApplicationContextAware {
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println(this.getClass() + ",获取applicationContext上下文:" + applicationContext);
    }
}
