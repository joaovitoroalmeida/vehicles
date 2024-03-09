package com.tinnova.vehicles.controller;

import com.tinnova.vehicles.controller.request.VehicleRequest;
import com.tinnova.vehicles.controller.request.mapper.VehicleMapper;
import com.tinnova.vehicles.controller.response.VehicleResponse;
import com.tinnova.vehicles.controller.response.mapper.VehicleResponseMapper;
import com.tinnova.vehicles.service.CreateVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("vehicles")
public class CreateVehicleController {

    private CreateVehicleService createVehicleService;
    private VehicleMapper vehicleMapper;
    private VehicleResponseMapper vehicleResponseMapper;

    @PostMapping
    public Mono<VehicleResponse> create(@RequestBody VehicleRequest request) {
        return createVehicleService.create(vehicleMapper.toVehicle(request))
                .map(vehicleResponseMapper::toResponse);
    }
}
