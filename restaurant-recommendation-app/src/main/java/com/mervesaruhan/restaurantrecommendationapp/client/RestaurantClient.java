package com.mervesaruhan.restaurantrecommendationapp.client;

import com.mervesaruhan.restaurantrecommendationapp.dto.response.CommentResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.restresponse.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "restaurant-service", url="http://localhost:8082/api/v1/restaurants")
@Component
public interface RestaurantClient {

    @GetMapping
    ResponseEntity<RestResponse<List<RestaurantDto>>> getAllRestaurants();

    @GetMapping("/{id}")
    ResponseEntity<RestResponse<RestaurantDto>> getRestaurantById(@PathVariable Long id);

    @PostMapping("/{restaurantId}/score-and-comments")
    void updateCommentsAndScore(@PathVariable Long restaurantId, @RequestBody List<CommentResponseDto> commentResponseDto);




}
