package com.tinnova.vehicles.controller.request.mapper;

import com.tinnova.vehicles.controller.request.PatchVehicleRequest;
import com.tinnova.vehicles.controller.request.VehicleRequest;
import com.tinnova.vehicles.domain.UpdateVehicle;
import com.tinnova.vehicles.domain.Vehicle;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.UUID;

@Component
public class VehicleMapper {

    public Vehicle toVehicle(VehicleRequest vehicleRequest) {
        return Vehicle.builder()
                .id(UUID.randomUUID())
                .vehicle(vehicleRequest.vehicle())
                .mark(vehicleRequest.mark())
                .year(vehicleRequest.year())
                .description(vehicleRequest.description())
                .color(vehicleRequest.color())
                .sold(vehicleRequest.sold())
                .created(Instant.now())
                .updated(Instant.now())
                .build();
    }

    public UpdateVehicle toUpdateVehicle(VehicleRequest vehicleRequest) {
        return UpdateVehicle.builder()
                .vehicle(vehicleRequest.vehicle())
                .mark(vehicleRequest.mark())
                .year(vehicleRequest.year())
                .description(vehicleRequest.description())
                .color(vehicleRequest.color())
                .sold(vehicleRequest.sold())
                .updated(Instant.now())
                .build();
    }

    public UpdateVehicle toUpdateVehicle(PatchVehicleRequest patchVehicleRequest) {
        return UpdateVehicle.builder()
                .vehicle(patchVehicleRequest.vehicle())
                .mark(patchVehicleRequest.mark())
                .year(patchVehicleRequest.year())
                .description(patchVehicleRequest.description())
                .color(patchVehicleRequest.color())
                .sold(patchVehicleRequest.sold())
                .updated(Instant.now())
                .build();
    }
}
