package com.haut.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.Arrays;


/**
 * @author xxx_xx
 * @date 2018/1/3
 * 指定消费offset
 */
public class SeekConsumer implements Runnable {

    KafkaConsumer consumer = new KafkaConsumer(Pro.getProps());
    TopicPartition topicPartition = new TopicPartition("event", 1);

    public void run() {
        consumer.assign(Arrays.asList(topicPartition));
        consumer.seek(topicPartition, 1);
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("分区" + record.partition() + " offset" + record.offset() + " value" + record.value());
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new SeekConsumer()).start();
    }
}
