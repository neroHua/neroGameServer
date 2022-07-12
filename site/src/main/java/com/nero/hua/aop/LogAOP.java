package com.nero.hua.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.*;

@Aspect
@Component
@Order(1)
@Slf4j
public class LogAOP {

    @Pointcut("execution(public * com.nero.hua.controller..*.*(..))")
    public void controllerPointcut() {
    }

    @Pointcut("execution(public * com.nero.hua.service..*.*(..))")
    public void servicePointcut() {
    }

    @Pointcut("execution(public * com.nero.hua.dao..*.*(..))")
    public void daoPointcut() {
    }

    @Pointcut("@annotation(com.nero.hua.aop.LogAOP.LogSkip)")
    public void logSkip() {
    }

    @Around("controllerPointcut() && !logSkip()")
    public Object controllerLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
        log.info("{}\t{}", "request start", requestURI);

        Object proceed = logParamsAndReturn(proceedingJoinPoint);
        log.info("{}\t{}", "request finish", requestURI);
        return proceed;
    }

    @Around("servicePointcut() || daoPointcut()")
    public Object serviceAndDaoLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = logParamsAndReturn(proceedingJoinPoint);
        return proceed;
    }

    private Object logParamsAndReturn(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        log.info("{}.{}-{}-args:{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), "in", JSON.toJSONString(args[0]));

        Object proceed = proceedingJoinPoint.proceed();
        log.info("{}.{}-{}-result:{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName(), "out", (JSON.toJSONString(proceed)));

        return proceed;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @Documented
    public static @interface LogSkip {
    }

}
