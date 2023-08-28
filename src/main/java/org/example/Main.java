package org.example;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.example.storage.StorageProperties;
import org.example.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // spring-boot-starter-web
@OpenAPIDefinition(info = @Info(title = "User API", version = "2.0", description = "User Details")) // springdoc-openapi-starter-webmvc-ui
@EnableConfigurationProperties(StorageProperties.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            try {
                storageService.init();
            }
            catch(Exception ex) {
                System.out.println("------Хюсто у нас проблеми" + ex.getMessage());
            }
        };
    }
}