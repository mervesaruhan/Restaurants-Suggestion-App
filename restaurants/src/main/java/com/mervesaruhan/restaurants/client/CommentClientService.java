package com.mervesaruhan.restaurants.client;

import com.mervesaruhan.restaurants.repository.RestaurantRepository;
import com.mervesaruhan.restaurants.restresponse.RestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class CommentClientService {
    private final CommentClient commentClient;
    private final RestaurantRepository restaurantRepository;

    public List<CommentResponseDto> getAllComments(){
        try{
            ResponseEntity<RestResponse<List<CommentResponseDto>>> allComments = commentClient.getAllComments();
            return Optional.ofNullable(allComments.getBody())
                    .map(RestResponse::getData)
                    .orElse(Collections.emptyList());

        } catch (Exception e) {
            log.error("Comment verisi alınamadı: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    public List<CommentResponseDto> getAllCommentsByRestaurantId(Long restaurantId) {
        try {
            ResponseEntity<RestResponse<List<CommentResponseDto>>> allComments = commentClient.getAllCommentsByRestaurantId(restaurantId);
            return Optional.ofNullable(allComments.getBody())
                    .map(RestResponse::getData)
                    .orElse(Collections.emptyList());
        } catch (Exception e) {
            log.error("Id'ye göre Comment verisi alınamadı: {}", e.getMessage());
            return Collections.emptyList();
        }

    }


}
