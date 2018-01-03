package com.haut.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import java.util.Properties;

/**
 * @author xxx_xx
 * @date 2018/1/3
 */
public class Pro {

    public static Properties getProps() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "47.104.74.198:9092,47.104.20.183:9092,47.104.21.120:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer1");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
