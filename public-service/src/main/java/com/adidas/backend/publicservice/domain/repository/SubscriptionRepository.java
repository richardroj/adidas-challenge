package com.adidas.backend.publicservice.domain.repository;

import com.adidas.backend.publicservice.domain.Subscription;

import java.util.Optional;

public interface SubscriptionRepository {
    Optional<Subscription> findById(String id);

    Subscription save(Subscription subscription);

    void delete(String id);

}
