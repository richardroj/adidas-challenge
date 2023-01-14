package com.adidas.backend.publicservice.infraestructure.messaging;

import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;

public interface SubscriptionEventPublisher {

    void publish(SubscriptionCreatedEvent subscriptionCreatedEvent);
}
