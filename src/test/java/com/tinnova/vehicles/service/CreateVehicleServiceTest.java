package com.tinnova.vehicles.service;

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
public class CreateVehicleServiceTest {

    @InjectMocks
    private CreateVehicleService createVehicleService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    @DisplayName("Successfully create vehicle")
    public void createVehicleTest() {
        var vehicleId = UUID.randomUUID();
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

        Mockito.when(vehicleRepository.create(Mockito.any())).thenReturn(
                Mono.just(vehicle)
        );

        Vehicle createdVehicle = createVehicleService.create(vehicle).block();

        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(vehicleId, createdVehicle.getId());
                    Assertions.assertEquals("Fit", createdVehicle.getVehicle());
                    Assertions.assertEquals("Honda", createdVehicle.getMark());
                    Assertions.assertEquals(2009, createdVehicle.getYear());
                    Assertions.assertEquals("This is a car", createdVehicle.getDescription());
                    Assertions.assertEquals("Black", createdVehicle.getColor());
                    Assertions.assertEquals(false, createdVehicle.getSold());
                    Assertions.assertEquals(instantNow, createdVehicle.getCreated());
                    Assertions.assertEquals(instantNow, createdVehicle.getUpdated());
                }
        );
    }
}
