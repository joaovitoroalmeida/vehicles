package com.tinnova.vehicles.domain;

import lombok.*;

import java.time.Instant;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateVehicle {
    private String vehicle;
    private String mark;
    private Integer year;
    private String description;
    private String color;
    private Boolean sold;
    private Instant updated;
}
