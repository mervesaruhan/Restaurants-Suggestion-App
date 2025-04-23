package com.mervesaruhan.restaurantrecommendationapp.service;

import com.mervesaruhan.restaurantrecommendationapp.dto.response.CommentResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.saverequest.CommentSaveDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest.CommentUpdateDto;
import com.mervesaruhan.restaurantrecommendationapp.entity.Comment;
import com.mervesaruhan.restaurantrecommendationapp.mapper.CommentMapper;
import com.mervesaruhan.restaurantrecommendationapp.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentResponseDto addComment(CommentSaveDto commentSaveDto) {
        Comment comment = commentMapper.toEntity(commentSaveDto);
        Comment saved =commentRepository.save(comment);
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
        return commentMapper.toDto(comment);
    }


    public void deleteCommentById(long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found: " + id));
        commentRepository.delete(comment);
    }
}
