package com.co.ias.clean_example.infraestructure.configuration;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class DbSecret {

    private final String url;
    private final String username;
    private final String password;

    private final String driverClass;

}
