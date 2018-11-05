package com.gyc.cap1.config;

import com.gyc.cap1.bean.Person;
import org.springframework.context.annotation.Bean;
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
public class MainCap1Config {
    @Bean
    public Person person() {
        return new Person("lisi", 19);
    }
}
