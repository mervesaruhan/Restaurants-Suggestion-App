package com.mervesaruhan.restaurantrecommendationapp.mapper;

import com.mervesaruhan.restaurantrecommendationapp.dto.response.CustomerResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.saverequest.CustomerSaveDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest.CustomerUpdateDto;
import com.mervesaruhan.restaurantrecommendationapp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses= CommentMapper.class)
public interface CustomerMapper {

    @Mapping(target = "customerFullname", expression = "java(customer.getName() + \" \" + customer.getSurname())")
    CustomerResponseDto toDto(Customer customer);

    Customer toEntity(CustomerSaveDto customerSaveDto);

    Customer toEntityUpdate(CustomerUpdateDto customerUpdateDto);

    List<CustomerResponseDto> toDtoList(List<Customer> customers);
}
