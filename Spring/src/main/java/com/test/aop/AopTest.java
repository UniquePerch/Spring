package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTest {
//    @Before("execution(* com.test.bean.Student.say(String))")//方法执行之前,也可以用joinpoint
//    public void before(JoinPoint joinPoint){
//        System.out.println(joinPoint);
//        System.out.println("方法执行之前");
//    }
//    @AfterReturning(value = "execution(* com.test.bean.Student.say(String))",returning = "val")//方法返回之后
//    public void after(Object val){
//        System.out.println("方法执行之后:"+val);
//    }
    @Around(value = "execution(* com.test.bean.Student.say(String))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法执行之前的操作");
        Object val = joinPoint.proceed();
        System.out.println("方法执行之后的操作");
        return val;
    }
}
