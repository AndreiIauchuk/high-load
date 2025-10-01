package com.iovchukandrew.highload.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PurchaseEvent {
    String userId;
    String sessionId;
    String orderId;
    double totalAmount;
    String currency;
}
