CREATE TABLE IF NOT EXISTS "vehicles" (
    "id"            UUID PRIMARY KEY,
    "vehicle"       VARCHAR(255) NOT NULL,
    "mark"          VARCHAR(50) NOT NULL,
    "year"          BIGINT NOT NULL,
    "description"   TEXT NOT NULL,
    "color"         VARCHAR(50) NOT NULL,
    "sold"          BOOL NOT NULL DEFAULT FALSE,
    "created"       TIMESTAMP NOT NULL,
    "updated"       TIMESTAMP NOT NULL
);