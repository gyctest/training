package com.gyc.cap12.custom;

import com.gyc.cap12.bean.Banana;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/9 0009
 */
@Component
public class Cap12BeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println(this.getClass().getName() + ".postProcessBeanFactory 调用,bean定义的数量:" + beanFactory.getBeanDefinitionCount());

    }

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println(this.getClass().getName() + ".postProcessBeanDefinitionRegistry 调用,bean定义的数量:" + registry.getBeanDefinitionCount());

        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Banana.class).getBeanDefinition();
        registry.registerBeanDefinition("aaa",beanDefinition);
    }

}
