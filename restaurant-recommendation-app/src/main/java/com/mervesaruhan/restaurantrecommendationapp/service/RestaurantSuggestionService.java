package com.mervesaruhan.restaurantrecommendationapp.service;

import com.mervesaruhan.restaurantrecommendationapp.repository.CommentRepository;
import com.mervesaruhan.restaurantrecommendationapp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantSuggestionService {
    private final CustomerRepository customerRepository;
    private final CommentRepository commentRepository;

}
