package com.tinnova.vehicles.controller;

import com.tinnova.vehicles.service.DeleteVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("vehicles")
public class DeleteVehicleController {

    private DeleteVehicleService deleteVehicleService;

    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable("id") UUID id) {
        return deleteVehicleService.deleteById(id);
    }
}
