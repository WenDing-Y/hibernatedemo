package com.haut.proxy;

/**
 * @author xxx_xx
 * @date 2017/12/27
 */
public class RealSubject implements  Subject {

    public void something() {
        System.out.println("do something");
    }
}
