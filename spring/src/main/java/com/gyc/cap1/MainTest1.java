package com.gyc.cap1;

import com.gyc.cap1.bean.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class MainTest1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");

        Person person = (Person) app.getBean("person");
        System.out.println(person);
        app.close();
    }
}
