package com.mervesaruhan.restaurantrecommendationapp.dto.saverequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CustomerSaveDto(
        @NotBlank(message =  "isim boş olamaz")
        @Size(max = 50, min=2, message = "İsim en az 2, en fazla 50 karakter olmalıdır.")
        String name,

        @NotBlank(message =  "Soyisim boş olamaz")
        @Size(max = 50, min=2, message = "Soyisim en az 2, en fazla 50 karakter olmalıdır.")
        String surname,

        @NotNull(message = "Enlem (latitude) boş olamaz.")
        @Positive(message = "Enlem pozitif olmalıdır.")
        Double latitude,

        @NotNull(message = "Boylam (longitude) boş olamaz.")
        @Positive(message = "Boylam pozitif olmalıdır.")
        Double longitude) {
}
