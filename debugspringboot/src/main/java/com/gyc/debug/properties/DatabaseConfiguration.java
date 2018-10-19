package com.gyc.debug.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/17 0017
 */
@Configuration
public class DatabaseConfiguration {
    @Bean
    @DatabaseType("mysql")
    public UserDao getMysqlDao() {
        return new MySQL();
    }

    @Bean
    @DatabaseType("oracle")
    public UserDao getOracleDao() {
        return new Oracle();
    }
}

