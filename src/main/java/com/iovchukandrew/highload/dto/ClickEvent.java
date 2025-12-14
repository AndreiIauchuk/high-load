package com.iovchukandrew.highload.dto;

import ch.qos.logback.core.joran.sanity.Pair;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ClickEvent extends Event {
    String url;
    String elementId;
    String elementType;
    String elementText;
    Pair<Integer, Integer> coordinates;
}
