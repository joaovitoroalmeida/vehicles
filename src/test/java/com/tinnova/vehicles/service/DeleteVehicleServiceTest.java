package com.tinnova.vehicles.service;

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

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class DeleteVehicleServiceTest {

    @InjectMocks
    private DeleteVehicleService deleteVehicleService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    @DisplayName("Successfully delete vehicle")
    public void deleteVehicleTest() {

        Mockito.when(vehicleRepository.deleteById(Mockito.any())).thenReturn(
                Mono.empty()
        );

        var deleteResult = deleteVehicleService.deleteById(UUID.randomUUID()).block();
        Assertions.assertNull(deleteResult);
    }
}