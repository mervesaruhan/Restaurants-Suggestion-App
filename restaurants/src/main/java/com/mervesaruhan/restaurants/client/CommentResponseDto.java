package com.mervesaruhan.restaurants.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentResponseDto {
    private Long id;
    private EnumScore score;
    private String text;
    private Long customerId;
    private String customerFullName;
    private String restaurantId;
}
