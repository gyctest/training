package com.gyc.cap2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/6 0006
 */
@Configuration
@ComponentScan("com.gyc.cap2.aop")
@EnableAspectJAutoProxy
public class MainCap10Config {

}
