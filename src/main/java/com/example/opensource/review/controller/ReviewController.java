package com.example.opensource.review.controller;

import com.example.opensource.review.dto.MovieReviewPageDto;
import com.example.opensource.review.dto.ReviewCreateRequestDto;
import com.example.opensource.review.dto.ReviewCreateResponseDto;
import com.example.opensource.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review/{movieId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 달고 싶은 특정 영화(리뷰)페이지에 접속한 후 리뷰 달기
    @PostMapping("/create")
    public ResponseEntity<ReviewCreateResponseDto> createReview(@PathVariable("movieId") Long movieId,
                                                                @RequestBody ReviewCreateRequestDto reviewCreateRequestDto) {
        ReviewCreateResponseDto reviewCreateResponseDto = reviewService.createReview(movieId, reviewCreateRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewCreateResponseDto);
    }

    // 리뷰 달고 싶은 영화 리뷰 페이지 접속하면 보이는 기본 화면
    // 하나의 특정 영화에 달린 리뷰 확인하는 페이지
    @GetMapping()
    public ResponseEntity<MovieReviewPageDto> findMovieReviews(@PathVariable("movieId") Long movieId){
        MovieReviewPageDto response = reviewService.findMovieReviews(movieId);
        return ResponseEntity.ok(response);
    }
}
