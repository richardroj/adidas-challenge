package com.adidas.backend.publicservice.infraestructure.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SubscriptionMessage {
    private String id;
    private String name;
    private String email;
}
