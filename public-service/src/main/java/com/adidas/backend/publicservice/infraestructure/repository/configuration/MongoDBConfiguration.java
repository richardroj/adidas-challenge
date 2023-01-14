package com.adidas.backend.publicservice.infraestructure.repository.configuration;

import com.adidas.backend.publicservice.infraestructure.repository.mongodb.SpringDataMongoSubscriptionRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = SpringDataMongoSubscriptionRepository.class)
public class MongoDBConfiguration {

}
