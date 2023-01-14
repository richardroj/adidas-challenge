package com.adidas.backend.publicservice.infraestructure.messaging;

import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionMessage;
import com.adidas.backend.publicservice.infraestructure.messaging.impl.SubscriptionEventPublisherImpl;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class SubscriptionEventPublisherTest {

    private SubscriptionEventPublisher subscriptionEventPublisher;

    @BeforeEach
    void setUp() {
        NewTopic topic = mock(NewTopic.class);
        KafkaTemplate<String, SubscriptionCreatedEvent> kafkaTemplate = mock(KafkaTemplate.class);
        subscriptionEventPublisher = new SubscriptionEventPublisherImpl(topic, kafkaTemplate);
    }

    @Test
    void shouldPublishEvent() {
        //given
        var event = SubscriptionCreatedEvent.builder()
            .message("Subscription Test")
            .subscriptionMessage(SubscriptionMessage.builder()
                .name("Subscription name")
                .id("1234Test")
                .email("test@test.com")
                .build())
            .build();
        subscriptionEventPublisher = mock(SubscriptionEventPublisherImpl.class);

        //when
        subscriptionEventPublisher.publish(event);

        //then
        verify(subscriptionEventPublisher, times(1)).publish(event);

    }

}
