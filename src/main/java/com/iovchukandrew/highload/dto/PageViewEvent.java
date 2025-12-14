package com.iovchukandrew.highload.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PageViewEvent extends Event {
    String url;
    @Builder.Default
    String userAgent = null;
    @Builder.Default
    String userIpAddress = null;
}
