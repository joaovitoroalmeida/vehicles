package com.tinnova.vehicles.repository.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatabaseProperties {
    private String url;
    private String user;
    private String password;
    private String driver;
}
