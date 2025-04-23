package com.mervesaruhan.restaurants.dto;

public record RestaurantResponseDto(
        Long id,
        String name,
        Double longitude,
        Double latitude,
        Double averageScore
) {
}
