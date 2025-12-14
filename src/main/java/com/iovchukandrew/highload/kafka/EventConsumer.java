package com.iovchukandrew.highload.kafka;

import com.iovchukandrew.highload.dto.PageViewEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@RequiredArgsConstructor
@Slf4j
public class EventConsumer {

    @Value("${kafka.topic.event.page-view:page-view-events}")
    private final String pageViewEventTopic;
    @Value("${kafka.topic.event.click:click-events}")
    private final String clickEventTopic;
    @Value("${kafka.topic.event.purchase:purchase-events}")
    private final String purchaseEventTopic;

    @KafkaListener(topics = "${kafka.topic.event.page-view:page-view-events}", groupId = "event-processor")
    public void processPageViewEvent(
            @Payload PageViewEvent event,
            @Header(KafkaHeaders.RECEIVED_KEY) String key
    ) {
        log.info("Message read from the topic {}:\nkey: {}; payload: {}", pageViewEventTopic, key, event);
        //TODO Do something. Save to DB, Redis?
    }

}
