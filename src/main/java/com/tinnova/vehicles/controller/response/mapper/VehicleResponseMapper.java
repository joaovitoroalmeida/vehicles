package com.tinnova.vehicles.controller.response.mapper;

import com.tinnova.vehicles.controller.response.VehicleResponse;
import com.tinnova.vehicles.domain.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleResponseMapper {

    public VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getVehicle(),
                vehicle.getMark(),
                vehicle.getYear(),
                vehicle.getDescription(),
                vehicle.getColor(),
                vehicle.getSold(),
                vehicle.getCreated(),
                vehicle.getUpdated()
        );
    }
}