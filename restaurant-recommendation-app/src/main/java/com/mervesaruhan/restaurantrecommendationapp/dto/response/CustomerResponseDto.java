package com.mervesaruhan.restaurantrecommendationapp.dto.response;

public record CustomerResponseDto(
        Long id,
        String customerFullname,
        Double longitude,
        Double latitude) {
}
