package com.haut.proxy;

/**
 * @author xxx_xx
 * @date 2017/12/27
 */
public class ProxyMain {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        World world = (World) new ProxyHandler().bind(new HelloWorld());
        world.sayHello(12);
    }
}
