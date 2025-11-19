package com.iovchukandrew.highload.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
@Import({KafkaConsumerConfig.class, KafkaProducerConfig.class})
public class KafkaConfig {
}
