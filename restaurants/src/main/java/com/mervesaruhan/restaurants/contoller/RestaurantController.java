package com.mervesaruhan.restaurants.contoller;


import com.mervesaruhan.restaurants.dto.RestaurantResponseDto;
import com.mervesaruhan.restaurants.dto.RestaurantSaveDto;
import com.mervesaruhan.restaurants.restresponse.RestResponse;
import com.mervesaruhan.restaurants.service.RestaurantService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="restaurants", description = "restaurants CRUD işlemleri")
@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
@Validated
public class RestaurantController {
    private final RestaurantService restaurantService;


    @PostMapping
    public ResponseEntity<RestResponse<RestaurantResponseDto>> saveRestaurant(@RequestBody @Valid RestaurantSaveDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RestResponse.of(restaurantService.saveRestaurant(dto)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<RestaurantResponseDto>>> getAllRestaurants() {
        return ResponseEntity.ok(RestResponse.of(restaurantService.getAllRestaurants()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<RestaurantResponseDto>> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(restaurantService.getRestaurantById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Void>> deleteRestaurantById(@PathVariable Long id) {
        restaurantService.deleteRestaurantById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
