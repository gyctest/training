package com.gyc.cap2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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

    @Pointcut("execution(public int com.gyc.cap2.aop.Calculator.div(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("【aspects】除法.............正常开始,参数列表{" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println("【aspects】除法.............结束");
    }

    @AfterReturning(value = "pointCut()", returning = "o")
    public void logReturn(Object o) {
        System.out.println("【aspects】除法.............正常返回结果{" + o + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(Exception e) {
        System.out.println("【aspects】除法.............Exception{" + "}");
    }

//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint joinPoint) {
//        System.out.println("【aspects@Around】除法...开始执行参数{" + Arrays.asList(joinPoint.getArgs()) + "}");
//        Object proceed = null;
//        try {
//            proceed = joinPoint.proceed(joinPoint.getArgs());
//        } catch (Throwable throwable) {
//            System.out.println(throwable.getMessage());
//        }
//
//        System.out.println("【aspects@Around】除法...结束执行,结果{" + proceed + "}");
//        return proceed;
//    }
}
