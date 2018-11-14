package com.gyc.demo.config;

import com.gyc.demo.filter.DemoFilter;
import com.gyc.demo.listener.DemoListener;
import com.gyc.demo.service.DemoService;
import com.gyc.demo.servlet.AsyncServlet;
import com.gyc.demo.servlet.DemoServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13 0013
 */
@HandlesTypes(DemoService.class)
public class DemoServletContainerInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%% Conatainer Initializer %%%%%%%%%%%%%%%%%55");
        if (c != null) {
            for (Class<?> aClass : c) {
                System.out.println("关心的类:" + aClass.getName());
            }
        }

        //servlet
        ServletRegistration.Dynamic servlet = ctx.addServlet("demo", DemoServlet.class);
        servlet.addMapping("/demo");

//        ctx.addServlet("asyn",AsyncServlet.class).addMapping("/async");

        //listener
        ctx.addListener(new DemoListener());

        //filter
        FilterRegistration.Dynamic demoFilter = ctx.addFilter("demoFilter", DemoFilter.class);
        demoFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");

    }
}
