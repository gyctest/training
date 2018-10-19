package com.gyc.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/17 0017
 */
public class DemoApplicationListener implements ApplicationListener {
//    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplicationListener.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 监听ApplicationStartingEvent
        if (event instanceof ApplicationStartedEvent) {
            logInfo("ApplicationStartedEvent listened");
        }

        // 监听ApplicationEnvironmentPreparedEvent
        else if (event instanceof ApplicationEnvironmentPreparedEvent) {
            logInfo("ApplicationEnvironmentPreparedEvent listened");
        }

        // 监听ApplicationPreparedEvent
        else if (event instanceof ApplicationPreparedEvent) {
            logInfo("ApplicationPreparedEvent listened");
        }

        // 监听ApplicationReadyEvent
        else if (event instanceof ApplicationReadyEvent) {
            logInfo("ApplicationReadyEvent listened");
        }

        // 监听ApplicationFailedEvent
        else if (event instanceof ApplicationFailedEvent) {
            logInfo("ApplicationFailedEvent listened");
        }

    }

    private void logInfo(String log) {
        System.out.println("aaaaaaaa:"+log);
    }

}
