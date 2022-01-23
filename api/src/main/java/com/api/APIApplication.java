package com.api;

import com.api.config.properties.AppProperties;
import com.api.config.properties.CorsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {  "com.core", "com.api"})
@EnableScheduling
@EnableConfigurationProperties({
        CorsProperties.class,
        AppProperties.class
})
@ConfigurationPropertiesScan
public class APIApplication {
    public static void main(String[] args) {
        SpringApplication.run(APIApplication.class, args);
    }
}
