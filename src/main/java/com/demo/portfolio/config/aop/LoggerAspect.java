package com.demo.portfolio.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("@annotation(org.springframework.web.bind.annotation.RestController)")
    public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        log.info("{}.{}()", signature.getDeclaringTypeName(), signature.getName());
        return joinPoint.proceed();
    }

    @Around("@annotation(org.springframework.stereotype.Repository)")
    public Object printArgs(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        log.info("{}.{}()", signature.getDeclaringTypeName(), signature.getName());
        log.info("{}", joinPoint.getArgs());
        return joinPoint.proceed();
    }

}
