package com.adidas.backend.prioritysaleservice.mapper;

import com.adidas.backend.prioritysaleservice.model.User;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;

public class SubscriptionMapper {

    User toSubscription(SubscriptionCreatedEvent subscriptionCreatedEvent){
        return new User();
    }
}
