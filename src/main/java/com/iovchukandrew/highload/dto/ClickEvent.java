package com.iovchukandrew.highload.dto;


import ch.qos.logback.core.joran.sanity.Pair;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClickEvent {
    String userId;
    String sessionId;
    String url;
    String elementId;
    String elementType;
    String elementText;
    Pair<Integer, Integer> coordinates;
}
