package com.tinnova.vehicles.controller;

import com.tinnova.vehicles.controller.request.PatchVehicleRequest;
import com.tinnova.vehicles.controller.request.VehicleRequest;
import com.tinnova.vehicles.controller.request.mapper.VehicleMapper;
import com.tinnova.vehicles.service.UpdateVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("vehicles")
public class UpdateVehicleController {

    private VehicleMapper vehicleMapper;
    private UpdateVehicleService updateVehicleService;

    @PutMapping(path = "{id}")
    public Mono<Void> updateById(@PathVariable("id") UUID id, @RequestBody VehicleRequest request) {
        return updateVehicleService.updateById(id, vehicleMapper.toUpdateVehicle(request));
    }

    @PatchMapping(path = "{id}")
    public Mono<Void> patchById(@PathVariable("id") UUID id, @RequestBody PatchVehicleRequest request) {
        return updateVehicleService.patchById(id, vehicleMapper.toUpdateVehicle(request));
    }
}
