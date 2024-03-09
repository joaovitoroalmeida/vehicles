package com.tinnova.vehicles.repository.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
public class DatabaseConfiguration {

    private final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean("dbRWClient")
    public DatabaseClient dbRWClient(@Qualifier("dbRWConnectionFactory") ConnectionFactory connectionFactory) {
        logger.debug("Starting database connection...");
        return DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .build();
    }

    @Bean("dbRWConnectionFactory")
    public ConnectionFactory dbRWConnectionFactory(@Qualifier("dbRWProperties") DatabaseProperties databaseProperties) {
        return resolveConnection(databaseProperties);
    }


    @Bean("dbRWProperties")
    @ConfigurationProperties(prefix = "spring.r2dbc.read-write")
    public DatabaseProperties dbRWProperties() {
        return new DatabaseProperties();
    }

    private ConnectionFactory resolveConnection(DatabaseProperties dbProperties) {
        return ConnectionFactories.get(
                ConnectionFactoryOptions
                        .parse(dbProperties.getUrl())
                        .mutate()
                        .option(ConnectionFactoryOptions.USER, dbProperties.getUser())
                        .option(ConnectionFactoryOptions.PASSWORD, dbProperties.getPassword())
                        .option(ConnectionFactoryOptions.DRIVER, dbProperties.getDriver())
                        .build()
        );
    }
}
