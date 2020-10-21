package ua.lviv.iot.tools.spring.first.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.tools.spring.first.rest.dataaccess",
        "ua.lviv.iot.tools.spring.first.rest.business",
        "ua.lviv.iot.tools.spring.first.rest.controller" })
@EnableJpaRepositories("ua.lviv.iot.tools.spring.first.rest.dataaccess")
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}  