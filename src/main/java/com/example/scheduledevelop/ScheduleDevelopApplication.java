package com.example.scheduledevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JpaAuditing 적용
@EnableJpaAuditing
@SpringBootApplication
public class ScheduleDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleDevelopApplication.class, args);
    }

}
