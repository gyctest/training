package com.gyc.cap2.custom;

import com.gyc.cap2.bean.cap6.Pig2;
import org.springframework.beans.factory.FactoryBean;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class Cap6FactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new Pig2();
    }

    public Class<?> getObjectType() {
        return Pig2.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
