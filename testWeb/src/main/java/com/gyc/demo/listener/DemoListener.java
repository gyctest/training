package com.gyc.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13 0013
 */
public class DemoListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Demo Listener.contextInitialized() xxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Demo Listener.contextDestroyed() xxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
}
