package com.adidas.backend.publicservice.application.request;

import com.adidas.backend.publicservice.application.request.dto.SubscriptionDto;
import com.adidas.backend.publicservice.domain.Subscription;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;

import java.util.UUID;

@Data
public class CreateSubscriptionRequest {
    @NotNull
    private SubscriptionDto subscriptionDto;

    public CreateSubscriptionRequest(@JsonProperty("subscription") @NotNull final SubscriptionDto subscriptionDto) {
        this.subscriptionDto = subscriptionDto;
    }

}
