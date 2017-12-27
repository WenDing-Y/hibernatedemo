package com.haut.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xxx_xx
 * @date 2017/12/27
 */
public class ProxyHandler implements InvocationHandler {

    private Object object ;

    public Object bind(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start log");
        Object object = method.invoke(this.object, args);
        System.out.println("end log");
        return object;
    }
}
