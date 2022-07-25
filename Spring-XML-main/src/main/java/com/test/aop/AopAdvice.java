package com.test.aop;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AopAdvice implements AfterReturningAdvice,MethodBeforeAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行之后");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行之前");
    }
}
