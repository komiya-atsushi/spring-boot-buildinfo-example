package me.k11i.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ExampleApp {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApp.class, args);
    }
}

@RestController
class ExampleApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleApi.class);

    public ExampleApi(@Autowired BuildProperties buildProperties) {
        LOGGER.info("App version: {}", buildProperties.getVersion());
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
