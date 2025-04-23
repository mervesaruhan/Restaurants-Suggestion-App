package com.mervesaruhan.restaurantrecommendationapp.dto.response;

import com.mervesaruhan.restaurantrecommendationapp.enums.EnumScore;

public record CommentResponseDto(
        Long id,
        EnumScore score,
        String text,
        Long customerId,
        String customerFullName,
        String restaurantId) {
}
