package com.yongyan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yongyan on 09/09/2018
 * controllers call services, services call repositories, and repositories communicate with database directly!
 */

/**
 * When developing Spring Boot applications, you need to tell the Spring Framework where to look for Spring components.
 * Using component scan is one method of asking Spring to detect Spring managed components. Spring needs the information
 * to locate and register all the Spring components with the application context when the application starts.
 */

@SpringBootApplication // set component scan to scan the package "com.yongyan"
public class LocationServiceApplication {
    // the entrance of application
    public static void main(String[] args) {
        SpringApplication.run(LocationServiceApplication.class, args);
    }
}
