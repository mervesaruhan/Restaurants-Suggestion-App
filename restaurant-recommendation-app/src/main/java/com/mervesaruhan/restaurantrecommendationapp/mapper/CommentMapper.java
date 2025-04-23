package com.mervesaruhan.restaurantrecommendationapp.mapper;

import com.mervesaruhan.restaurantrecommendationapp.dto.response.CommentResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.saverequest.CommentSaveDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest.CommentUpdateDto;
import com.mervesaruhan.restaurantrecommendationapp.entity.Comment;
import com.mervesaruhan.restaurantrecommendationapp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    @Mapping(target = "customerFullName", expression = "java(comment.getCustomer().getName() + \" \" + comment.getCustomer().getSurname())")
    @Mapping(target= "customerId", source= "customer.id")
    CommentResponseDto toDto(Comment comment);

    @Mapping(source = "customerId", target = "customer")
    Comment toEntity(CommentSaveDto commentSaveRequest);

    //Comment toEntityUpdate(CommentUpdateDto commentSaveDto); updatete manuel setleme yapılır

    List<CommentResponseDto> toDtoList(List<Comment> commentList);

    default Customer mapCustomer(Long customerId) {
        if (customerId == null) return null;
        Customer customer = new Customer();
        customer.setId(customerId);
        return customer;

    }
}
