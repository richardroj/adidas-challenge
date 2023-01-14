package com.adidas.backend.publicservice.domain.service;

import com.adidas.backend.publicservice.domain.Subscription;
import com.adidas.backend.publicservice.domain.repository.SubscriptionRepository;
import com.adidas.backend.publicservice.infraestructure.messaging.SubscriptionEventPublisher;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;
import com.adidas.backend.publicservice.infraestructure.messaging.mapper.SubscriptionCreatedEventMapper;

public class DomainSubscriptionService implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionEventPublisher subscriptionEventPublisher;
    private final SubscriptionCreatedEventMapper createdEventMapper;

    public DomainSubscriptionService(SubscriptionRepository subscriptionRepository,
                                     SubscriptionEventPublisher subscriptionEventPublisher,
                                     SubscriptionCreatedEventMapper createdEventMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionEventPublisher = subscriptionEventPublisher;
        this.createdEventMapper = createdEventMapper;
    }

    @Override
    public String createSubscription(Subscription subscription) {
        subscription = subscriptionRepository.save(subscription);
        SubscriptionCreatedEvent createdEvent = createdEventMapper.toSubscriptionCreatedEvent(subscription);
        subscriptionEventPublisher.publish(createdEvent);
        return subscription.getId();
    }

    @Override
    public void deleteSubscription(String subscriptionId) {
        subscriptionRepository.delete(subscriptionId);
    }

}
