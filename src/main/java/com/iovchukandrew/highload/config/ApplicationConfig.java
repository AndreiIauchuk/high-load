package com.iovchukandrew.highload.config;

import com.iovchukandrew.highload.kafka.KafkaConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({KafkaConfig.class})
public class ApplicationConfig {
}
