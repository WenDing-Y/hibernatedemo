package com.haut.aop;


import org.aspectj.lang.JoinPoint;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
public class DepartLog {

    public void beforeLog(JoinPoint joinpoint) {
        System.out.println(joinpoint.getSignature().getName());
        System.out.println("start log");
    }

    public void afterLog() {
        System.out.println("finish log");
    }
}
