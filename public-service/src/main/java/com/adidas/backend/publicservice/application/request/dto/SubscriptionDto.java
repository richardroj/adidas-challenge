package com.adidas.backend.publicservice.application.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SubscriptionDto {
    private String uuid;
    private String name;
    private String email;

}
