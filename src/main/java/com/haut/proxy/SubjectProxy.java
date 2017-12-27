package com.haut.proxy;

/**
 * @author xxx_xx
 * @date 2017/12/27
 */
public class SubjectProxy implements  Subject {
    RealSubject realSubject = new RealSubject();
    public void something() {
        realSubject.something();
    }
}
