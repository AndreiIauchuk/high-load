package com.iovchukandrew.highload.kafka;

import com.iovchukandrew.highload.dto.ClickEvent;
import com.iovchukandrew.highload.dto.PageViewEvent;
import com.iovchukandrew.highload.dto.PurchaseEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@RequiredArgsConstructor
@Slf4j
public class EventPublisher {

    @Value("${kafka.topic.event.page-view:page-view-events}")
    String pageViewEventTopic;

    @Value("${kafka.topic.event.click:click-events}")
    String clickEventTopic;

    @Value("${kafka.topic.event.purchase:purchase-events}")
    String purchaseEventTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishPageViewEvent(PageViewEvent event) {
        kafkaTemplate.send(pageViewEventTopic, event.getUserId(), event);
    }

    public void publishClickEvent(ClickEvent event) {
        kafkaTemplate.send(clickEventTopic, event.getUserId(), event);
    }

    public void publishPurchaseEvent(PurchaseEvent event) {
        kafkaTemplate.send(purchaseEventTopic, event.getUserId(), event);
    }
}
