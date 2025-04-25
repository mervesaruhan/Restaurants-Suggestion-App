package com.mervesaruhan.restaurantrecommendationapp.service;

import com.mervesaruhan.restaurantrecommendationapp.client.RestaurantClientService;
import com.mervesaruhan.restaurantrecommendationapp.client.RestaurantDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.response.CommentResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.saverequest.CommentSaveDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest.CommentUpdateDto;
import com.mervesaruhan.restaurantrecommendationapp.entity.Comment;
import com.mervesaruhan.restaurantrecommendationapp.entity.Customer;
import com.mervesaruhan.restaurantrecommendationapp.mapper.CommentMapper;
import com.mervesaruhan.restaurantrecommendationapp.repository.CommentRepository;
import com.mervesaruhan.restaurantrecommendationapp.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final RestaurantClientService restaurantClientService;
    private final CustomerRepository customerRepository;

    public CommentResponseDto addComment(CommentSaveDto commentSaveDto) {
        Comment comment = commentMapper.toEntity(commentSaveDto);
        Customer customer = customerRepository.findById(comment.getCustomer().getId()).orElse(null);
        RestaurantDto restaurant = restaurantClientService.getRestaurantById(comment.getRestaurantId());

        if(customer == null) { throw new EntityNotFoundException("Customer not found"); }
        if (restaurant == null) { throw new EntityNotFoundException("Restaurant not found"); }

        comment.setCustomer(customer);
        Comment saved =commentRepository.save(comment);
        updateRestaurantByCommentsAndScore(commentSaveDto.restaurantId());

        return commentMapper.toDto(saved);
    }


    public List<CommentResponseDto> getAllComments() {
        return commentMapper.toDtoList(commentRepository.findAll());
    }


    public CommentResponseDto updateComment(long id,CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment not found: " + id));
        comment.setScore(commentUpdateDto.score());
        comment.setText(commentUpdateDto.text());
        commentRepository.save(comment);

        updateRestaurantByCommentsAndScore(comment.getRestaurantId());
        return commentMapper.toDto(comment);
    }


    public void deleteCommentById(long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found: " + id));
        commentRepository.delete(comment);

        Long restaurantId = comment.getRestaurantId();
        restaurantClientService.updateRestaurantByCommentsAndScore(restaurantId,getAllByRestaurantId(restaurantId));
    }

    public void updateRestaurantByCommentsAndScore(Long restaurantId) {
        restaurantClientService.updateRestaurantByCommentsAndScore(restaurantId, getAllByRestaurantId(restaurantId));
    }

    public List<CommentResponseDto> getAllByRestaurantId(Long restaurantId) {
        List<Comment> allByRestaurantId = commentRepository.findAllByRestaurantId(restaurantId);
        return commentMapper.toDtoList(allByRestaurantId);
    }

}
