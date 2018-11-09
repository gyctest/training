package com.gyc.cap12.test;

import com.gyc.cap12.config.MainCap12Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/9 0009
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap12Config.class);

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
        for (String s : app.getBeanDefinitionNames()) {
            System.out.println(s);
        }
        app.close();
    }
}
