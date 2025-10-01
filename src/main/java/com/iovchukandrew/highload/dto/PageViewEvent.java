package com.iovchukandrew.highload.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PageViewEvent {
    String userId;
    String sessionId;
    String url;
    String userAgent;
    String userIpAddress;
}
