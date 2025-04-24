package com.mervesaruhan.restaurantrecommendationapp.dto.saverequest;

import com.mervesaruhan.restaurantrecommendationapp.enums.EnumScore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentSaveDto(

        @NotNull(message =  "Puanlama boş olamaz.")
        EnumScore score,

        @NotBlank(message =  "Yorum boş olamaz.")
        @Size(max = 50, min=2, message = "Yorum en az 2, en fazla 500 karakter olmalıdır.")
        String text,

        @NotNull(message = "Müşteri ID boş olamaz.")
        Long customerId,

        @NotBlank(message = "Restoran ID boş olamaz.")
        Long restaurantId) {
}
