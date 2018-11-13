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
@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoQualifier {
    String value() default "";

}
