package com.adidas.backend.publicservice.infraestructure.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionCreatedEvent {
    private String message;
    private SubscriptionMessage subscriptionMessage;

}
