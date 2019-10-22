package com.bdqn.hx.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.bdqn.hx.service.*.*(..))")
    public void operationLog(){}

    // 环绕增强，写了环绕增强，就不用分开写
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法入参："+ Arrays.toString(jp.getArgs()));
        try {
            Object result = jp.proceed();
            logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。返回值是："+ result);
            return result;
        } catch (Throwable e) {
            logger.info(jp.getSignature().getName()+"方法发生异常："+e);
            throw e;
        }finally {
            logger.info(jp.getSignature().getName()+"方法结束执行.....");
        }
    }

 /*   @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint jp){
        System.out.println("前置增强，进入方法前执行.....");
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。方法入参："+ Arrays.toString(jp.getArgs()));
    }

    @AfterReturning(returning = "returnValue", pointcut = "operationLog()")
    public void doAfterReturningAdvice(JoinPoint jp, Object returnValue) {
        System.out.println("后置增强，方法执行后返回结果.....");
        logger.info("调用"+jp.getTarget()+"的"+jp.getSignature().getName()+"方法。返回值是："+ returnValue);
    }

    @AfterThrowing(throwing = "e", pointcut = "operationLog()")
    public void doThrowsAdvice(JoinPoint jp, RuntimeException e){
        System.out.println("异常增强，方法抛出异常时执行.....");
        logger.info(jp.getSignature().getName()+"方法发生异常："+e);
    }

    @After("operationLog()")
    public void doAfterAdvice(JoinPoint jp){
        System.out.println("最终增强，无论是否抛出异常都执行.....");
        logger.info(jp.getSignature().getName()+"方法结束执行.....");
    }*/

}

