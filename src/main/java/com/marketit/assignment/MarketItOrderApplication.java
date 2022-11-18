package com.marketit.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MarketItOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketItOrderApplication.class, args);
    }
}
