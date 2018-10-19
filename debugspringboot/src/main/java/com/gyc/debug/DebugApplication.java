package com.gyc.debug;

import com.gyc.debug.properties.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/17 0017
 */
@SpringBootApplication
public class DebugApplication {


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DebugApplication.class);
        application.addInitializers(new DemoApplicationContextInitializer());
        application.addListeners(new DemoApplicationListener());
        String[] bb = {"aaa","bbb"};

        System.setProperty("dbType","oracle");
        application.run(bb);


    }
}
