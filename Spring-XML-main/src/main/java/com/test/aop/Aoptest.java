package com.test.aop;

import lombok.extern.java.Log;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Array;
import java.util.Arrays;

@Log
public class Aoptest {

    public void before(){
        log.info("执行前");
    }
    public void after(JoinPoint point){
        System.out.println(point.getThis());
        log.info("执行后");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前置");
        Object res = joinPoint.proceed();
        System.out.println("环绕方法");
        return res;
    }
}
