package com.iovchukandrew.highload.rest.event;

import com.iovchukandrew.highload.dto.ClickEvent;
import com.iovchukandrew.highload.dto.Event;
import com.iovchukandrew.highload.dto.PageViewEvent;
import com.iovchukandrew.highload.dto.PurchaseEvent;
import com.iovchukandrew.highload.kafka.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final EventPublisher eventPublisher;

    //Track page views
    @PostMapping("/page-view")
    public ResponseEntity<Void> pageView(@RequestBody PageViewEvent request) {
        eventPublisher.publishPageViewEvent(request);
        return ResponseEntity.ok().build();
    }

    //Track user clicks
    @PostMapping("/click")
    public ResponseEntity<Void> click(@RequestBody ClickEvent request) {
        eventPublisher.publishClickEvent(request);
        return ResponseEntity.ok().build();
    }

    //Track completed purchases
    @PostMapping("/purchase")
    public ResponseEntity<Void> purchase(@RequestBody PurchaseEvent request) {
        eventPublisher.publishPurchaseEvent(request);
        return ResponseEntity.ok().build();
    }
}
