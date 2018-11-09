package com.gyc.cap11.test;

import com.gyc.cap11.config.MainCap11Config;
import com.gyc.cap11.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/8 0008
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test11cap() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap11Config.class);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        for (String beanName : app.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        OrderService bean = app.getBean(OrderService.class);
        bean.insert();
        app.close();
    }
}
