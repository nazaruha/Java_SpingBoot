package org.example;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // spring-boot-starter-web
@OpenAPIDefinition(info = @Info(title = "User API", version = "2.0", description = "User Details")) // springdoc-openapi-starter-webmvc-ui
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}