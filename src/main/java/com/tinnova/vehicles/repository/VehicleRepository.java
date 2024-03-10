package com.tinnova.vehicles.repository;

import com.tinnova.vehicles.domain.UpdateVehicle;
import com.tinnova.vehicles.domain.Vehicle;
import com.tinnova.vehicles.domain.VehicleProperties;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface VehicleRepository {

    Mono<Vehicle> create(Vehicle vehicle);

    Mono<Void> deleteById(UUID id);

    Flux<Vehicle> getAll();

    Flux<Vehicle> getByProperties(VehicleProperties vehicleProperties);

    Mono<Vehicle> getById(UUID id);

    Mono<Void> updateById(UUID id, UpdateVehicle vehicle);
}
