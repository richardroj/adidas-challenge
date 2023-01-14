package com.adidas.backend.publicservice.infraestructure.messaging.impl;

import com.adidas.backend.publicservice.infraestructure.messaging.SubscriptionEventPublisher;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.lang.String.*;

@Service
public class SubscriptionEventPublisherImpl implements SubscriptionEventPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionEventPublisherImpl.class);

    private final NewTopic topic;

    private final KafkaTemplate<String, SubscriptionCreatedEvent> kafkaTemplate;

    public SubscriptionEventPublisherImpl(NewTopic topic, KafkaTemplate<String,
        SubscriptionCreatedEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(SubscriptionCreatedEvent subscriptionCreatedEvent) {
        LOGGER.info(format("Subscription event => %s", subscriptionCreatedEvent.toString()));
        // create Message
        Message<SubscriptionCreatedEvent> message = MessageBuilder
            .withPayload(subscriptionCreatedEvent)
            .setHeader(KafkaHeaders.TOPIC, topic.name())
            .build();
        kafkaTemplate.send(message);
    }

}
