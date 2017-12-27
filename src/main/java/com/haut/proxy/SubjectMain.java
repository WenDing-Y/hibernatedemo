package com.haut.proxy;

/**
 * @author xxx_xx
 * @date 2017/12/27
 */
public class SubjectMain {

    public static void main(String[] args) {
        Subject subject = new SubjectProxy();
        subject.something();
    }
}
