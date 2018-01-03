package com.haut.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;

/**
 * @author xxx_xx
 * @date 2018/1/3
 */
public class ConsumeGroup implements Runnable {

    KafkaConsumer consumer = new KafkaConsumer(Pro.getProps());

    public void run() {
        consumer.subscribe(Arrays.asList("event"));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("分区" + record.partition() + "offset" + record.offset() + "value"+record.value());
            }
        }
    }
}
