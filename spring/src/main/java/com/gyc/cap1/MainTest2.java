package com.gyc.cap1;

import com.gyc.cap1.bean.Person;
import com.gyc.cap1.config.MainCap1Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class MainTest2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainCap1Config.class);
        Person person = (Person) app.getBean("person");
        System.out.println(person);
        app.close();
    }
}
