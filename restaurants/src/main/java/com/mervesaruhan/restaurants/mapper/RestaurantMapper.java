package com.mervesaruhan.restaurants.mapper;

import com.mervesaruhan.restaurants.dto.RestaurantResponseDto;
import com.mervesaruhan.restaurants.dto.RestaurantSaveDto;
import com.mervesaruhan.restaurants.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring",unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantResponseDto toDto(Restaurant restaurant);
    Restaurant toEntity(RestaurantSaveDto dto);
    List<RestaurantResponseDto> toDtoList(List<Restaurant> restaurantList);
}
