package com.tinnova.vehicles.service;

import com.tinnova.vehicles.domain.UpdateVehicle;
import com.tinnova.vehicles.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateVehicleService {

    private VehicleRepository vehicleRepository;

    public Mono<Void> updateById(UUID id, UpdateVehicle updateVehicle) {
        return vehicleRepository.updateById(id, updateVehicle);
    }

    public Mono<Void> patchById(UUID id, UpdateVehicle updateVehicle) {
        return vehicleRepository.getById(id)
                .map(vehicle ->
                        UpdateVehicle.builder()
                                .vehicle(updateVehicle.getVehicle() != null ? updateVehicle.getVehicle() : vehicle.getVehicle())
                                .mark(updateVehicle.getMark() != null ? updateVehicle.getMark() : vehicle.getMark())
                                .year(updateVehicle.getYear() != null ? updateVehicle.getYear() : vehicle.getYear())
                                .description(updateVehicle.getDescription() != null ? updateVehicle.getDescription() : vehicle.getDescription())
                                .color(updateVehicle.getColor() != null ? updateVehicle.getColor() : vehicle.getColor())
                                .sold(updateVehicle.getSold() != null ? updateVehicle.getSold() : vehicle.getSold())
                                .updated(updateVehicle.getUpdated())
                                .build()

                ).flatMap(updateVehicle1 -> vehicleRepository.updateById(id, updateVehicle1));
    }
}
