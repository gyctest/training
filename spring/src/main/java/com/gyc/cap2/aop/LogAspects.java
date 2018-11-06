package com.gyc.cap2.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/6
 */
@Component
@Aspect
public class LogAspects {

    @Pointcut("")
    public void pointCut() {

    }

    public void logStart(Joinpoint joinpoint) {
        System.out.println("除法正常返回");
    }

    public void logEnd() {
        System.out.println("除法正常返回");
    }

    public void logReturn() {
        System.out.println("除法正常返回");
    }

    public void logException(Exception e) {
        System.out.println("Exception{" + e + "}");
    }

    @Around("pointCut()")
    public void around() {
        System.out.println("除法正常返回");
    }
}
