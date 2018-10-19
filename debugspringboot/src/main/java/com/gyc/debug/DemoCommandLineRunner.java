package com.gyc.debug;

import com.gyc.debug.properties.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/17 0017
 */
@Component
@Order(1)
public class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("自定义CommandLineRunner运行了 "+userDao);

    }
}
