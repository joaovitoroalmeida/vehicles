package com.tinnova.vehicles.repository.impl;

import com.tinnova.vehicles.domain.UpdateVehicle;
import com.tinnova.vehicles.domain.Vehicle;
import com.tinnova.vehicles.domain.VehicleProperties;
import com.tinnova.vehicles.repository.VehicleRepository;
import io.r2dbc.spi.Row;
import lombok.AllArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class VehicleRepositoryImpl implements VehicleRepository {

    private DatabaseClient dbRWClient;

    @Override
    public Mono<Vehicle> create(Vehicle vehicle) {
        return dbRWClient.sql(VehicleConstants.INSERT_VEHICLE)
                .bind("id", vehicle.getId())
                .bind("vehicle", vehicle.getVehicle())
                .bind("mark", vehicle.getMark())
                .bind("year", vehicle.getYear())
                .bind("description", vehicle.getDescription())
                .bind("color", vehicle.getColor())
                .bind("sold", vehicle.getSold())
                .bind("created", vehicle.getCreated())
                .bind("updated", vehicle.getUpdated())
                .map(((row, rowMetadata) -> toVehicle(row)))
                .first();
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return dbRWClient.sql(VehicleConstants.DELETE_BY_ID)
                .bind("id", id)
                .fetch()
                .first()
                .then();
    }

    @Override
    public Flux<Vehicle> getAll() {
        return dbRWClient.sql(VehicleConstants.SELECT_ALL)
                .map((row, rowMetadata) -> toVehicle(row))
                .all();
    }

    @Override
    public Flux<Vehicle> getByProperties(VehicleProperties vehicleProperties) {
        return dbRWClient.sql(VehicleConstants.SELECT_BY_PROPERTIES)
                .bind("mark", "%" + vehicleProperties.mark() + "%")
                .bind("year", vehicleProperties.year())
                .bind("color", "%" + vehicleProperties.color() + "%")
                .map((row, rowMetadata) -> toVehicle(row))
                .all();
    }

    @Override
    public Mono<Vehicle> getById(UUID id) {
        return dbRWClient.sql(VehicleConstants.SELECT_BY_ID)
                .bind("id", id)
                .map((row, rowMetadata) -> toVehicle(row))
                .first();
    }

    @Override
    public Mono<Void> updateById(UUID id, UpdateVehicle vehicle) {
        return dbRWClient.sql(VehicleConstants.UPDATE_ALL_BY_ID)
                .bind("id", id)
                .bind("vehicle", vehicle.getVehicle())
                .bind("mark", vehicle.getMark())
                .bind("year", vehicle.getYear())
                .bind("description", vehicle.getDescription())
                .bind("color", vehicle.getColor())
                .bind("sold", vehicle.getSold())
                .bind("updated", vehicle.getUpdated())
                .fetch()
                .first()
                .then();
    }

    private Vehicle toVehicle(Row row) {
        return Vehicle.builder()
                .id((UUID) row.get("id"))
                .vehicle((String) row.get("vehicle"))
                .mark((String) row.get("mark"))
                .year(((Long) Objects.requireNonNull(row.get("year"))).intValue())
                .description((String) row.get("description"))
                .color((String) row.get("color"))
                .sold((Boolean) row.get("sold"))
                .created(((LocalDateTime) Objects.requireNonNull(row.get("created"))).toInstant(ZoneOffset.UTC))
                .updated(((LocalDateTime) Objects.requireNonNull(row.get("updated"))).toInstant(ZoneOffset.UTC))
                .build();
    }
}
