package com.example.opensource.review.service;

import com.example.opensource.review.dto.MovieReviewPageDto;
import com.example.opensource.review.dto.ReviewCreateRequestDto;
import com.example.opensource.review.dto.ReviewCreateResponseDto;

public interface ReviewService {
    ReviewCreateResponseDto createReview(Long movieId, ReviewCreateRequestDto reviewCreateRequestDto);
    MovieReviewPageDto findMovieReviews(Long movieId);
}
