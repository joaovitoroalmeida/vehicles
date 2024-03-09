package com.tinnova.vehicles.controller.request;

public record PatchVehicleRequest(
        String vehicle,
        String mark,
        Integer year,
        String description,
        String color,
        Boolean sold
) {
}
