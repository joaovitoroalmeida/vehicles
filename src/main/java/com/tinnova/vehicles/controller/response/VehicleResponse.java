package com.tinnova.vehicles.controller.response;

import java.time.Instant;
import java.util.UUID;

public record VehicleResponse(
        UUID id,
        String vehicle,
        String mark,
        Integer year,
        String description,
        String color,
        Boolean sold,
        Instant created,
        Instant updated
) {
}
