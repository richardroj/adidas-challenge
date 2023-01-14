package com.adidas.backend.publicservice.domain.service;

import com.adidas.backend.publicservice.domain.Subscription;
import com.adidas.backend.publicservice.domain.repository.SubscriptionRepository;
import com.adidas.backend.publicservice.infraestructure.messaging.SubscriptionEventPublisher;
import com.adidas.backend.publicservice.infraestructure.messaging.mapper.SubscriptionCreatedEventMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class DomainSubscriptionServiceTest {

    private DomainSubscriptionService subscriptionService;
    private SubscriptionRepository subscriptionRepository;
    private SubscriptionEventPublisher subscriptionEventPublisher;
    private SubscriptionCreatedEventMapper createdEventMapper;

    @BeforeEach
    void setUp() {
        subscriptionRepository = mock(SubscriptionRepository.class);
        subscriptionEventPublisher = mock(SubscriptionEventPublisher.class);
        createdEventMapper = mock(SubscriptionCreatedEventMapper.class);
        subscriptionService = new DomainSubscriptionService(subscriptionRepository,
            subscriptionEventPublisher, createdEventMapper);
    }

    @Test
    void shouldCreateASubscription() {
        //given
        String id = "1234test";
        var subscription = new Subscription("id", "name", "email");

        //when
        Mockito.when(subscriptionRepository.save(Mockito.any())).thenReturn(Subscription.builder().id(id).build());
        var result = subscriptionService.createSubscription(subscription);

        //then
        Assertions.assertEquals(id, result);
    }

    @Test
    void shouldDeleteASubscription() {
        //given
        String id = "1234test";

        subscriptionService = mock(DomainSubscriptionService.class);

        //when
        subscriptionService.deleteSubscription(id);

        //then
        verify(subscriptionService, times(1)).deleteSubscription(id);
    }

}
