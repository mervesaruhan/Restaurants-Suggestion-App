package com.mervesaruhan.restaurantrecommendationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantRecommendationAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantRecommendationAppApplication.class, args);
    }

}
