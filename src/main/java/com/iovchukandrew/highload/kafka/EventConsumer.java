package com.iovchukandrew.highload.kafka;

import com.iovchukandrew.highload.dto.PageViewEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

@RequiredArgsConstructor
@Slf4j
public class EventConsumer {

    @KafkaListener(topics = "page-view-events", groupId = "event-processor")
    public void processPageViewEvent(
            @Payload PageViewEvent event,
            @Header(KafkaHeaders.RECEIVED_KEY) String key
    ) {
        // Обогащение данных (например, информация о пользователе из PostgreSQL)
        User user = userRepository.findById(event.getUserId());
        event.setUserSegment(user.getSegment());

        // Сохранение в Cassandra
        eventRepository.save(event);

        // Обновление счетчиков в Redis
        redisTemplate.opsForValue().increment("product:views:" + event.getProductId());
    }

}
