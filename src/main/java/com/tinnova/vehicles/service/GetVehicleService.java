package com.tinnova.vehicles.service;

import com.tinnova.vehicles.domain.Vehicle;
import com.tinnova.vehicles.domain.VehicleProperties;
import com.tinnova.vehicles.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetVehicleService {

    private VehicleRepository vehicleRepository;
    private final Logger logger = LoggerFactory.getLogger(GetVehicleService.class);

    public Flux<Vehicle> getAll() {
        logger.info("Get all vehicles");
        return vehicleRepository.getAll();
    }

    public Mono<Vehicle> getById(UUID id) {
        logger.info("Get vehicle by id {}", id);
        return vehicleRepository.getById(id);
    }

    public Flux<Vehicle> getByProperties(VehicleProperties properties) {
        logger.info("Get vehicle by properties {}", properties.toString());
        return vehicleRepository.getByProperties(properties);
    }
}
