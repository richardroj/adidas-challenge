package com.adidas.backend.publicservice.infraestructure.repository.mongodb;

import com.adidas.backend.publicservice.domain.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoSubscriptionRepository extends MongoRepository<Subscription, UUID> {
}
