package com.adidas.backend.publicservice.infraestructure.repository.configuration;

import com.adidas.backend.publicservice.PublicServiceApplication;
import com.adidas.backend.publicservice.domain.repository.SubscriptionRepository;
import com.adidas.backend.publicservice.domain.service.DomainSubscriptionService;
import com.adidas.backend.publicservice.domain.service.SubscriptionService;
import com.adidas.backend.publicservice.infraestructure.messaging.SubscriptionEventPublisher;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;
import com.adidas.backend.publicservice.infraestructure.messaging.impl.SubscriptionEventPublisherImpl;
import com.adidas.backend.publicservice.infraestructure.messaging.mapper.SubscriptionCreatedEventMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
@ComponentScan(basePackageClasses = PublicServiceApplication.class)
public class BeanConfiguration {

    @Bean
    SubscriptionEventPublisher subscriptionEventPublisher(final NewTopic topic,
                                                          KafkaTemplate<String,
                                                              SubscriptionCreatedEvent> kafkaTemplate) {
        return new SubscriptionEventPublisherImpl(topic, kafkaTemplate);
    }

    @Bean
    SubscriptionService subscriptionService(final SubscriptionRepository subscriptionRepository,
                                            final SubscriptionEventPublisher subscriptionEventPublisher,
                                            final SubscriptionCreatedEventMapper createdEventMapper) {
        return new DomainSubscriptionService(subscriptionRepository, subscriptionEventPublisher,
            createdEventMapper);
    }

}
