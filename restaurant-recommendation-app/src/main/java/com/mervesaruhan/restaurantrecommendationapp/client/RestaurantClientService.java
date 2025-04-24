package com.mervesaruhan.restaurantrecommendationapp.client;


import ch.qos.logback.classic.Logger;
import com.mervesaruhan.restaurantrecommendationapp.restresponse.RestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantClientService {
    private final RestaurantClient restaurantClient;

    public List<RestaurantDto> getRestaurants() {
        try {
            ResponseEntity<RestResponse<List<RestaurantDto>>> response = restaurantClient.getAllRestaurants();
            return Optional.ofNullable(response.getBody())
                    .map(RestResponse::getData)
                    .orElse(Collections.emptyList());
//            if (response.getBody() != null && response.getBody().getData() != null) {
//                return response.getBody().getData();
//            } else {
//                return Collections.emptyList();
//            }
        } catch (Exception e) {
            log.error("Restaurant verisi alınamadı: {}", e.getMessage());
            return Collections.emptyList();
        }
    }


    public RestaurantDto getRestaurantById(@PathVariable Long id) {
        try{
            ResponseEntity<RestResponse<RestaurantDto>> response = restaurantClient.getRestaurantById(id);
            return response.getBody().getData();
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}
