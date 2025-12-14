package com.iovchukandrew.highload.kafka;

import com.iovchukandrew.highload.dto.ClickEvent;
import com.iovchukandrew.highload.dto.Event;
import com.iovchukandrew.highload.dto.PageViewEvent;
import com.iovchukandrew.highload.dto.PurchaseEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.event.page-view:page-view-events}")
    private final String pageViewEventTopic;
    @Value("${kafka.topic.event.click:click-events}")
    private final String clickEventTopic;
    @Value("${kafka.topic.event.purchase:purchase-events}")
    private final String purchaseEventTopic;

    public void publishPageViewEvent(PageViewEvent event) {
        send(pageViewEventTopic, event, PageViewEvent.class);
    }

    public void publishClickEvent(ClickEvent event) {
        send(clickEventTopic, event, ClickEvent.class);
    }

    public void publishPurchaseEvent(PurchaseEvent event) {
        send(purchaseEventTopic, event, PurchaseEvent.class);
    }

    private <T extends Event> void send(String topic, T event, Class<?> dtoClass) {
        log.info("Sending {} to Kafka: {}", dtoClass.getSimpleName(), event);
        kafkaTemplate.send(topic, event.getUserId(), event);
        log.info("{} was sent to Kafka", dtoClass.getSimpleName());
    }
}
