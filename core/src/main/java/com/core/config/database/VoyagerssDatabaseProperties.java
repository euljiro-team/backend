package com.core.config.database;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("db-euljiro")
@Data
@Component
public class VoyagerssDatabaseProperties {

    String url;
    String username;
    String password;
    String driverClassName;
}
