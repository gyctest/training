package com.gyc.demo;

import com.gyc.demo.config.DemoAppConfig;
import com.gyc.demo.config.DemoRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13 0013
 */
public class DemoWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("###################### getRootConfigClasses ######################3");
        return new Class[]{DemoRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("###################### getServletConfigClasses ######################3");
        return new Class[]{DemoAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("###################### getServletMappings ######################3");
        return new String[]{"/"};
    }
}
