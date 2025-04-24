package com.mervesaruhan.restaurantrecommendationapp.client;

import com.mervesaruhan.restaurantrecommendationapp.restresponse.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "restaurant-service", url="http://localhost:8082/api/v1/restaurants")
@Component
public interface RestaurantClient {

    @GetMapping
    ResponseEntity<RestResponse<List<RestaurantDto>>> getAllRestaurants();

    @GetMapping
    ResponseEntity<RestResponse<RestaurantDto>> getRestaurantById(@PathVariable Long id);




}
