package com.tinnova.vehicles.service;

import com.tinnova.vehicles.domain.Vehicle;
import com.tinnova.vehicles.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CreateVehicleService {

    private VehicleRepository vehicleRepository;
    private final Logger logger = LoggerFactory.getLogger(CreateVehicleService.class);

    public Mono<Vehicle> create(Vehicle vehicle) {
        logger.info("Create vehicle {}", vehicle.toString());
        return vehicleRepository.create(vehicle);
    }
}
