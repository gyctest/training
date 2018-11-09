package com.gyc.cap12.config;


import com.gyc.cap12.bean.Apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/9 0009
 */
@Configuration
@ComponentScan("com.gyc.cap12")
public class MainCap12Config {

    @Bean
    public Apple apple() {
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setKg(0.2);
        return apple;
    }
}
