package com.tinnova.vehicles.repository.impl;

public class VehicleConstants {

    public static final String INSERT_VEHICLE = """
                INSERT INTO vehicles (id, vehicle, mark, year, description, color, sold, created, updated)
                VALUES (:id, :vehicle, :mark, :year, :description, :color, :sold, :created, :updated)
                RETURNING *;
            """;

    public static final String DELETE_BY_ID = """
                DELETE FROM vehicles WHERE id = :id;
            """;

    public static final String SELECT_ALL = """
                SELECT * FROM vehicles;
            """;

    public static final String SELECT_BY_PROPERTIES = """
                SELECT * FROM vehicles WHERE mark LIKE :mark AND year = :year AND color LIKE :color;
            """;

    public static final String SELECT_BY_ID = """
                SELECT * FROM vehicles WHERE id = :id;
            """;

    public static final String UPDATE_ALL_BY_ID = """
                UPDATE vehicles SET vehicle = :vehicle, mark = :mark, year = :year, description = :description, color = :color, sold = :sold, updated = :updated
                WHERE id = :id;
            """;

}
