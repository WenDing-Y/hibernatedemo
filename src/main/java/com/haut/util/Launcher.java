package com.haut.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
public class Launcher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        context.start();
        BatchUtil batchUtil = (BatchUtil) context.getBean("batchUtil");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 2; i++) {
            executorService.submit(batchUtil);
        }
        executorService.shutdown();
        context.stop();
    }
}
