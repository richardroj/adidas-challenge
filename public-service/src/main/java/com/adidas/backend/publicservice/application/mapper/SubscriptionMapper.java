package com.adidas.backend.publicservice.application.mapper;

import com.adidas.backend.publicservice.application.request.dto.SubscriptionDto;
import com.adidas.backend.publicservice.domain.Subscription;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SubscriptionMapper {

    public Subscription toSubscription(SubscriptionDto subscriptionDto){
        return Subscription.builder()
            .id(UUID.randomUUID().toString())
            .name(subscriptionDto.getName())
            .email(subscriptionDto.getEmail())
            .build();
    }
}
