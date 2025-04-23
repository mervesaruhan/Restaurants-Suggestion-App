package com.mervesaruhan.restaurants.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private Long id;
    private EnumScore score;
    private String text;
    private Long customerId;
    private String customerFullName;
    private String restaurantI;
}
