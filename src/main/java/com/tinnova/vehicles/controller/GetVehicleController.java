package com.tinnova.vehicles.controller;

import com.tinnova.vehicles.controller.response.VehicleResponse;
import com.tinnova.vehicles.controller.response.mapper.VehicleResponseMapper;
import com.tinnova.vehicles.domain.VehicleProperties;
import com.tinnova.vehicles.service.GetVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("vehicles")
public class GetVehicleController {

    private GetVehicleService getVehicleService;
    private VehicleResponseMapper vehicleResponseMapper;

    @GetMapping
    public Flux<VehicleResponse> getAll(@RequestParam(value = "mark", required = false) String mark,
                                        @RequestParam(value = "year", required = false) Integer year,
                                        @RequestParam(value = "color", required = false) String color
    ) {
        if (mark != null && year != null && color != null) {
            return getVehicleService.getByProperties(
                    new VehicleProperties(
                            mark,
                            year,
                            color
                    )
            ).map(vehicleResponseMapper::toResponse);
        }

        return getVehicleService.getAll()
                .map(vehicleResponseMapper::toResponse);
    }

    @GetMapping("{id}")
    public Mono<VehicleResponse> getById(@PathVariable("id") UUID id) {
        return getVehicleService.getById(id)
                .map(vehicleResponseMapper::toResponse);
    }
}
