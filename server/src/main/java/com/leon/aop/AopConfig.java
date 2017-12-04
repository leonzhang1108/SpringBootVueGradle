package com.leon.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


/**
 * Author: jianliangzhang
 * Date: 2017/11/30
 * Time: 10:41
 */
@Aspect
@Configuration
public class AopConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning("execution(* com.leon.dao..*.*(..))")
    public void logServiceAccessAfterReturning(JoinPoint joinPoint) {
        logger.info("Completed: " + joinPoint);
    }

    @Before("execution(* com.leon.dao..*.*(..))")
    public void logServiceAccessBefore(JoinPoint joinPoint) {
        logger.info("Before: " + joinPoint);
    }
}
