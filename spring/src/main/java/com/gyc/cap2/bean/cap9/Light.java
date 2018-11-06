package com.gyc.cap2.bean.cap9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/6 0006
 */
@Component
public class Light implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
    public void setBeanName(String name) {
        System.out.println("当前bean名字:" + name);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("IOC 上线文" + applicationContext);
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println(resolver.resolveStringValue("运行环境${os.name},两个值相加#{3+30}"));
    }
}
