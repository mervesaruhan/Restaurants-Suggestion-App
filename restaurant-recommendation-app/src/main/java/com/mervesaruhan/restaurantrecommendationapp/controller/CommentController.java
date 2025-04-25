package com.mervesaruhan.restaurantrecommendationapp.controller;

import com.mervesaruhan.restaurantrecommendationapp.dto.response.CommentResponseDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.saverequest.CommentSaveDto;
import com.mervesaruhan.restaurantrecommendationapp.dto.updaterequest.CommentUpdateDto;
import com.mervesaruhan.restaurantrecommendationapp.restresponse.RestResponse;
import com.mervesaruhan.restaurantrecommendationapp.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name= "restaurant recommendation app", description = "Customer CRUD işlemleri")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;


    @PostMapping
    public ResponseEntity<RestResponse<CommentResponseDto>> saveComment(@RequestBody @Valid CommentSaveDto commentSaveDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(RestResponse.of(commentService.addComment(commentSaveDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CommentResponseDto>> updateComment(@RequestBody @Valid CommentUpdateDto commentUpdateDto, @PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(commentService.updateComment(id, commentUpdateDto)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CommentResponseDto>>> getAllComments() {
        return ResponseEntity.ok(RestResponse.of(commentService.getAllComments()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Void>> deleteComment(@PathVariable Long id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/{restaurantsId}")
    public ResponseEntity<RestResponse<List<CommentResponseDto>>> getAllCommentsByRestaurantId(@PathVariable Long restaurantsId) {
        return ResponseEntity.ok(RestResponse.of(commentService.getAllByRestaurantId(restaurantsId)));
    }
}

