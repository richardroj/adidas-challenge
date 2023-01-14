package com.adidas.backend.publicservice.infraestructure.messaging.mapper;

import com.adidas.backend.publicservice.domain.Subscription;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionMessage;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionCreatedEventMapper {
    public SubscriptionCreatedEvent toSubscriptionCreatedEvent(Subscription subscription){
        return SubscriptionCreatedEvent.builder()
            .message("New-Subscription")
            .subscriptionMessage(SubscriptionMessage.builder()
                .email(subscription.getEmail())
                .name(subscription.getName())
                .id(subscription.getId())
                .build())
            .build();
    }
}
