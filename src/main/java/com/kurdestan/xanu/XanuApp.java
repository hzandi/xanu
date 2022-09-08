package com.kurdestan.xanu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class XanuApp {

    public static void main(String[] args) {
        SpringApplication.run(XanuApp.class);
    }
}