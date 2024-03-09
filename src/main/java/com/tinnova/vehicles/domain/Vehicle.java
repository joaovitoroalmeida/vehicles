package com.tinnova.vehicles.domain;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private UUID id;
    private String vehicle;
    private String mark;
    private Integer year;
    private String description;
    private String color;
    private Boolean sold;
    private Instant created;
    private Instant updated;
}
