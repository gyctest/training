package com.gyc.cap2.config;

import com.gyc.cap2.bean.cap8.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
@PropertySource(value = "classpath:/test.properties",encoding="GBK")
@Configuration
public class MainCap8Config {

    @Bean
    public Bird bird() {
        return new Bird();
    }
}
