package com.example.springbatch.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.batch.core.scope.BatchScopeSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpringbatchAop {

    @Pointcut("execution(public void org.springframework.batch.core.scope.BatchScopeSupport.postProcessBeanFactory(..))")
    public void scopeStepPointCut() {
    }

    /**
     * 该种方式无法修改postProcessBeanFactory中的autoProxy值
     * @param joinPoint
     */
    @Before("scopeStepPointCut()")
    public void changeAutoProxy(JoinPoint joinPoint) {
        ((BatchScopeSupport)joinPoint.getTarget()).setAutoProxy(true);
    }

    /**
     * aop
     */
    @Pointcut("execution(public * com.example.springbatch.controller.BatchController.batch(..))")
    public void test(){
    }

    @Around("test()")
    public void testProxy(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("testProxy");
        joinPoint.proceed();
    }


    /**
     * aop中使用动态参数
     */
    @Value("${aopList:execution(public * com.example.springbatch.controller.BatchController.batch(..))}")
    private String aopList;

    @Around(value = "#aopList")
    public void test2Proxy(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("test2Proxy");
        joinPoint.proceed();
    }
}
