package com.mervesaruhan.restaurantrecommendationapp.client;

public record RestaurantDto(
        Long id,
        String name,
        Double longitude,
        Double latitude,
        Double averageScore
) {
}