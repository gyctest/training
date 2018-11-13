package com.gyc.demo.annotation;

import java.lang.annotation.*;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DemoRequestParam {
    String value() default "";
}
