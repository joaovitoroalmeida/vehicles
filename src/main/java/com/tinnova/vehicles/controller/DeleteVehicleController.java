package com.tinnova.vehicles.controller;

import com.tinnova.vehicles.service.DeleteVehicleService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
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
