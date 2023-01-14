package com.adidas.backend.publicservice.application.response;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateSubscriptionResponse {
    private final String id;

    public CreateSubscriptionResponse(final String id) {
        this.id = id;
    }

}
