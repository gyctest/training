package com.gyc.cap2.custom;

import com.gyc.cap2.bean.cap6.Pig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class Cap6BeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean dog = registry.containsBeanDefinition("com.gyc.cap2.bean.cap6.Dog");
        boolean cat = registry.containsBeanDefinition("com.gyc.cap2.bean.cap6.Cat");
        if (dog && cat) {
            BeanDefinition root = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig", root);
        }
    }
}
