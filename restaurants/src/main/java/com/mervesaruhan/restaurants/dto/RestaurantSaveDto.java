package com.mervesaruhan.restaurants.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record RestaurantSaveDto(

        @NotBlank(message =  "İsim boş olamaz.")
        @Size(min = 1, max = 150)
        String name,

        @NotNull(message =  "Boylam boş olamaz.")
        @Positive(message = "Boylam pozitif olmalıdır.")
        Double longitude,

        @NotNull(message =  "Enlem boş olamaz.")
        @Positive(message = "Enlem pozitif olmalıdır.")
        Double latitude

                        ) {
}
