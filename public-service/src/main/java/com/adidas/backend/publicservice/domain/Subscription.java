package com.adidas.backend.publicservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@Document
public class Subscription {
    @Id
    private String id;
    private String name;
    private String email;

}
