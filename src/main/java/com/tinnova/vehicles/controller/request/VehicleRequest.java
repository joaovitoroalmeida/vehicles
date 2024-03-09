package com.tinnova.vehicles.controller.request;

import jakarta.validation.constraints.NotNull;

public record VehicleRequest(
        @NotNull(message = "vehicle may not be null")
        String vehicle,
        @NotNull(message = "mark may not be null")
        String mark,
        @NotNull(message = "year may not be null")
        Integer year,
        @NotNull(message = "description may not be null")
        String description,

        @NotNull(message = "color may not be null")
        String color,
        @NotNull(message = "sold may not be null")
        Boolean sold
) {}
