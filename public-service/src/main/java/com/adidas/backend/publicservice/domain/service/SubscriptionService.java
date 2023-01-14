package com.adidas.backend.publicservice.domain.service;

import com.adidas.backend.publicservice.domain.Subscription;

public interface SubscriptionService {
    String createSubscription(Subscription subscription);

    void deleteSubscription(String subscriptionId);

}
