package com.gyc.cap2.config;

import com.gyc.cap2.bean.cap7.Bike;
import com.gyc.cap2.bean.cap7.Train;
import com.gyc.cap2.custom.Cap7BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
@Configuration
//@ComponentScan("com.gyc.cap2.bean.cap7")
@ComponentScans({@ComponentScan("com.gyc.cap2.bean.cap7")})
public class MainCap7Config {

    @Bean(destroyMethod = "destory", initMethod = "init")
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Bike bike() {
        Bike bike = new Bike();
        System.out.println("bike 配置调用.............");
        return bike;
    }

    @Bean
    public Train train() {
        Train train = new Train();
        System.out.println("train 配置调用.............");
        return train;
    }

    @Bean
    public Cap7BeanPostProcessor beanPostProcessor() {
        return new Cap7BeanPostProcessor();
    }
}
