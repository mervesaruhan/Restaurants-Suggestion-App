package com.mervesaruhan.restaurants.client;

import com.mervesaruhan.restaurants.restresponse.RestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="comment", url = "http://customers:8080/api/v1/comments")
@Component
public interface CommentClient {

    @GetMapping("/{restaurantId}")
    ResponseEntity<RestResponse<List<CommentResponseDto>>> getAllCommentsByRestaurantId(@PathVariable Long restaurantId);

    @GetMapping
    ResponseEntity<RestResponse<List<CommentResponseDto>>> getAllComments();
}
