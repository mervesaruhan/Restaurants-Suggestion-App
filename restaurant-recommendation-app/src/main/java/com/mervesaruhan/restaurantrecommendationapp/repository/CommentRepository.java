package com.mervesaruhan.restaurantrecommendationapp.repository;

import com.mervesaruhan.restaurantrecommendationapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByRestaurantId(Long restaurantId);
}
