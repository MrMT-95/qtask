package com.company.qtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class QtaskApplication {

    public static void main(String[] args) {

        SpringApplication.run(QtaskApplication.class, args);
    }

}
