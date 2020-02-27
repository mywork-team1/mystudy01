package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

	@Around("execution(* *.hello(..))")
	public void myTestAdvice(ProceedingJoinPoint pip) throws Throwable {
		System.out.println("Test1");
		pip.proceed();
		System.out.println("Test2");
	}
}
