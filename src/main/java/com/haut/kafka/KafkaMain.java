package com.haut.kafka;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xxx_xx
 * @date 2018/1/3
 */
public class KafkaMain {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 3; i++) {
            service.submit(new Thread(new ConsumeGroup()));
        }
        service.shutdown();
    }

}
