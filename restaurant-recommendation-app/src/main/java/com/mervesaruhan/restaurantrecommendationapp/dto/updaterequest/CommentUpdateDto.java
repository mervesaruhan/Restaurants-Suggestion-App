package com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest;

import com.mervesaruhan.restaurantrecommendationapp.enums.EnumScore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentUpdateDto(

        @NotBlank(message = "Yorum metni boş olamaz.")
        @Size(min = 2, max = 500)
        String text,

        @NotNull(message = "Puan boş olamaz.")
        EnumScore score
) {
}
