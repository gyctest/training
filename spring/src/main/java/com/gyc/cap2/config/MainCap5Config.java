package com.gyc.cap2.config;

import com.gyc.cap2.bean.Person;
import com.gyc.cap2.custom.Cap2LinuxCondition;
import com.gyc.cap2.custom.Cap2WinCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
@Configuration
public class MainCap5Config {

    @Bean("linuxPerson")
    @Conditional(Cap2LinuxCondition.class)
    public Person getPerson() {
        return new Person("linux", 30);
    }

    @Bean("WindPerson")
    @Conditional(Cap2WinCondition.class)
    public Person getPerson2() {
        return new Person("window", 20);
    }

}
