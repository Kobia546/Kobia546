package com.example.projetsecurite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetSecuriteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSecuriteApplication.class, args);
    }

}
