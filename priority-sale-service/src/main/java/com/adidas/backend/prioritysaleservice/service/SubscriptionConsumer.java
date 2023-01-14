package com.adidas.backend.prioritysaleservice.service;

import com.adidas.backend.prioritysaleservice.model.User;
import com.adidas.backend.publicservice.infraestructure.messaging.dto.SubscriptionCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubscriptionConsumer.class);

    @Autowired
    UserService userService;

    @Autowired
    AdiClubService adiClubService;

    @KafkaListener(
        topics = "${spring.kafka.topic.name}"
        , groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(SubscriptionCreatedEvent event) {
        LOGGER.info(String.format("Subscription event received in service => %s", event.toString()));

        var adiClubMemberInfoDto = adiClubService.getAdiClubInfoByEmail(
            event.getSubscriptionMessage().getEmail());

        LOGGER.info("Getting user from adiclub " + adiClubMemberInfoDto);
        userService.addUser(User.builder()
            .email(event.getSubscriptionMessage().getEmail())
            .name(event.getSubscriptionMessage().getName())
            .points(adiClubMemberInfoDto.getPoints())
            .registrationDate(adiClubMemberInfoDto.getRegistrationDate())
            .build());

    }

}
