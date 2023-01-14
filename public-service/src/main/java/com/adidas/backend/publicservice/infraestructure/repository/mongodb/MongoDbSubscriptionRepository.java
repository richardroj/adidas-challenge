package com.adidas.backend.publicservice.infraestructure.repository.mongodb;

import com.adidas.backend.publicservice.domain.Subscription;
import com.adidas.backend.publicservice.domain.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class MongoDbSubscriptionRepository implements SubscriptionRepository {
    private final SpringDataMongoSubscriptionRepository subscriptionRepository;

    @Autowired
    public MongoDbSubscriptionRepository(SpringDataMongoSubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Optional<Subscription> findById(String id) {

        return subscriptionRepository.findAll()
            .stream()
            .filter(it -> it.getId().equals(id))
            .findFirst();
    }

    @Override
    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void delete(String id) {

        var subscription = subscriptionRepository.findAll()
            .stream()
            .filter(it -> it.getId().equals(id))
            .findFirst();
        subscription.ifPresent(subscriptionRepository::delete);
    }

}
