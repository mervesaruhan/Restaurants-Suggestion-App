package com.mervesaruhan.restaurants.service;

import com.mervesaruhan.restaurants.dto.RestaurantResponseDto;
import com.mervesaruhan.restaurants.dto.RestaurantSaveDto;
import com.mervesaruhan.restaurants.entity.Restaurant;
import com.mervesaruhan.restaurants.mapper.RestaurantMapper;
import com.mervesaruhan.restaurants.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantResponseDto  saveRestaurant(RestaurantSaveDto restaurantSaveDto) {
        Restaurant restaurant = restaurantMapper.toEntity(restaurantSaveDto);
        return restaurantMapper.toDto(restaurantRepository.save(restaurant));
    }

    public List<RestaurantResponseDto> getAllRestaurants() {
        return restaurantMapper.toDtoList(restaurantRepository.findAll());
    }

    public RestaurantResponseDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurant not found: " + id));
        return restaurantMapper.toDto(restaurant);
    }

    public void deleteRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurant not found: " + id));
        restaurantRepository.delete(restaurant);
    }
}
