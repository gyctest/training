package com.gyc.cap2.config;

import com.gyc.cap2.custom.Cap2TypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
@Configuration
//@ComponentScan(basePackages = {"com.gyc.cap2"})
//@ComponentScan(basePackages = {"com.gyc.cap2"}, includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})}
//        , useDefaultFilters = false
//)
@ComponentScan(basePackages = {"com.gyc.cap2"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {Cap2TypeFilter.class})}
        , useDefaultFilters = false
)
public class MainCap2Config {


}
