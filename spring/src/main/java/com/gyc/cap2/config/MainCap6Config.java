package com.gyc.cap2.config;

import com.gyc.cap2.bean.cap6.Cat;
import com.gyc.cap2.bean.cap6.Dog;
import com.gyc.cap2.custom.Cap6BeanDefinitionRegistrar;
import com.gyc.cap2.custom.Cap6FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
@Configuration
//@Import(Dog.class)
//@Import({Dog.class, Cat.class, Cap6ImportSelector.class})
@Import({Dog.class, Cat.class, Cap6BeanDefinitionRegistrar.class})
public class MainCap6Config {


    @Bean
    public Cap6FactoryBean cap6FactoryBean() {
        return new Cap6FactoryBean();
    }
}
