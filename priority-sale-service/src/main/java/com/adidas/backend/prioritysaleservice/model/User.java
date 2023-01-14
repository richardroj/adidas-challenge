package com.adidas.backend.prioritysaleservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private String email;
    private Integer points;
    private Instant registrationDate;

}
