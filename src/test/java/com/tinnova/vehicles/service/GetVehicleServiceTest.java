package com.tinnova.vehicles.service;

import com.tinnova.vehicles.domain.Vehicle;
import com.tinnova.vehicles.domain.VehicleProperties;
import com.tinnova.vehicles.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class GetVehicleServiceTest {

    @InjectMocks
    private GetVehicleService getVehicleService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    @DisplayName("Successfully get all vehicles")
    public void getAllTest() {
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

        Mockito.when(vehicleRepository.getAll()).thenReturn(
                Flux.just(vehicle)
        );

        Flux<Vehicle> vehicles = getVehicleService.getAll();
        vehicles.flatMap(v -> {
                    Assertions.assertAll(
                            () -> {
                                Assertions.assertEquals(vehicleId, v.getId());
                                Assertions.assertEquals("Fit", v.getVehicle());
                                Assertions.assertEquals("Honda", v.getMark());
                                Assertions.assertEquals(2009, v.getYear());
                                Assertions.assertEquals("This is a car", v.getDescription());
                                Assertions.assertEquals("Black", v.getColor());
                                Assertions.assertEquals(false, v.getSold());
                                Assertions.assertEquals(instantNow, v.getCreated());
                                Assertions.assertEquals(instantNow, v.getUpdated());
                            }
                    );
                    return Flux.empty();
                }
        );
    }

    @Test
    @DisplayName("Successfully get vehicle by id")
    public void getByIdTest() {
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

        Mockito.when(vehicleRepository.getById(vehicleId)).thenReturn(
                Mono.just(vehicle)
        );

        Vehicle vehicleResult = getVehicleService.getById(vehicleId).block();
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(vehicleId, vehicleResult.getId());
                    Assertions.assertEquals("Fit", vehicleResult.getVehicle());
                    Assertions.assertEquals("Honda", vehicleResult.getMark());
                    Assertions.assertEquals(2009, vehicleResult.getYear());
                    Assertions.assertEquals("This is a car", vehicle.getDescription());
                    Assertions.assertEquals("Black", vehicleResult.getColor());
                    Assertions.assertEquals(false, vehicleResult.getSold());
                    Assertions.assertEquals(instantNow, vehicleResult.getCreated());
                    Assertions.assertEquals(instantNow, vehicleResult.getUpdated());
                }
        );
    }

    @Test
    @DisplayName("Successfully get vehicle by properties")
    public void getByPropertiesTest() {
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

        VehicleProperties properties = new VehicleProperties(
                "Honda",
                2009,
                "Black"
        );

        Mockito.when(vehicleRepository.getByProperties(properties)).thenReturn(
                Flux.just(vehicle)
        );

        Flux<Vehicle> vehiclesResult = getVehicleService.getByProperties(properties);
        vehiclesResult.flatMap(vehicles -> {
                    Assertions.assertAll(
                            () -> {
                                Assertions.assertEquals(vehicleId, vehicles.getId());
                                Assertions.assertEquals("Fit", vehicles.getVehicle());
                                Assertions.assertEquals("Honda", vehicles.getMark());
                                Assertions.assertEquals(2009, vehicles.getYear());
                                Assertions.assertEquals("This is a car", vehicles.getDescription());
                                Assertions.assertEquals("Black", vehicles.getColor());
                                Assertions.assertEquals(false, vehicles.getSold());
                                Assertions.assertEquals(instantNow, vehicles.getCreated());
                                Assertions.assertEquals(instantNow, vehicles.getUpdated());
                            }
                    );
                    return Flux.empty();
                }
        );
    }
}
