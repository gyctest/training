package com.gyc.cap2.test;

import com.gyc.cap2.aop.Calculator;
import com.gyc.cap2.bean.cap6.Pig2;
import com.gyc.cap2.bean.cap7.Train;
import com.gyc.cap2.bean.cap8.Bird;
import com.gyc.cap2.bean.cap9.Moon;
import com.gyc.cap2.bean.cap9.Sun;
import com.gyc.cap2.config.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class TestCap6 {
    @Test
    public void test6() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap6Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("==================================================");
        Object cap6FactoryBean = app.getBean("&cap6FactoryBean");
        System.out.println(cap6FactoryBean);
        System.out.println(app.getBean("cap6FactoryBean"));
        System.out.println(app.getBean(Pig2.class));
        app.close();
    }

    /**
     * bean生命周期
     */
    @Test
    public void test7() throws InterruptedException {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap7Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("==================================================");
        Object bike = app.getBean("bike");
        System.out.println(bike);
        bike = null;
        Object bike2 = app.getBean("bike");
        System.out.println(bike2);
        System.out.println("==================================================");
        Object train = app.getBean(Train.class);
        System.out.println(train);
//        Thread.sleep(1000);
        app.close();
    }


    @Test
    public void test8() throws InterruptedException {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap8Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Bird bean = app.getBean(Bird.class);
        System.out.println(bean);
        app.close();
    }

    @Test
    public void test9() throws InterruptedException {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap9Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        System.out.println(app.getBean(Moon.class));
        System.out.println(app.getBean(Sun.class));
        app.close();
    }

    @Test
    public void test10() throws InterruptedException {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap10Config.class);
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Calculator bean = app.getBean(Calculator.class);
        bean.div(4, 2);
        app.close();
    }
}
