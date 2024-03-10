package com.tinnova.vehicles.service;

import com.tinnova.vehicles.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteVehicleService {

    private VehicleRepository vehicleRepository;
    private final Logger logger = LoggerFactory.getLogger(DeleteVehicleService.class);

    public Mono<Void> deleteById(UUID id) {
        logger.info("Delete vehicle by id {}", id);
        return vehicleRepository.deleteById(id);
    }
}
