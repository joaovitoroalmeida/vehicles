package com.tinnova.vehicles.service;

import com.tinnova.vehicles.domain.UpdateVehicle;
import com.tinnova.vehicles.domain.Vehicle;
import com.tinnova.vehicles.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class UpdateVehicleServiceTest {

    @InjectMocks
    private UpdateVehicleService updateVehicleService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    @DisplayName("Successfully update vehicle by id")
    public void updateVehicleTest() {

        var vehicleId = UUID.randomUUID();
        var instantNow = Instant.now();
        UpdateVehicle updateVehicle = new UpdateVehicle(
                "Fit",
                "Honda",
                2009,
                "This is a car",
                "Black",
                false,
                instantNow
        );

        Mockito.when(vehicleRepository.updateById(vehicleId, updateVehicle)).thenReturn(
                Mono.empty()
        );

        var updateResult = updateVehicleService.updateById(vehicleId, updateVehicle).block();
        Assertions.assertNull(updateResult);
    }

    @Test
    @DisplayName("Successfully patch vehicle by id")
    public void patchVehicleTest() {

        var vehicleId = UUID.randomUUID();
        UpdateVehicle updateVehicle = UpdateVehicle.builder()
                .color("Red")
                .sold(true)
                .build();

        var instantNow = Instant.now();
        Vehicle vehicle = new Vehicle(
                vehicleId,
                "Fit",
                "Honda",
                2009,
                "This is a car",
                "Black",
                false,
                instantNow,
                instantNow
        );

        Mockito.when(vehicleRepository.getById(vehicleId)).thenReturn(
                Mono.just(vehicle)
        );

        Mockito.when(vehicleRepository.updateById(Mockito.any(), Mockito.any())).thenReturn(
                Mono.empty()
        );

        var updateResult = updateVehicleService.patchById(vehicleId, updateVehicle).block();
        Assertions.assertNull(updateResult);
    }
}
