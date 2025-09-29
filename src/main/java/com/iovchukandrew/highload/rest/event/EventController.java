package com.iovchukandrew.highload.rest.event;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/v1/event")
public class EventController {

    ///api/v1/events/page-view
    ///api/v1/events/click
    ///api/v1/events/purchase
    ///api/v1/events/batch

    @PostMapping("/page-view")
    public PageViewResponse pageView() {
        return new PageViewResponse();
    }

}
