package com.example.opensource.review.service;

import com.example.opensource.movie.domain.Movie;
import com.example.opensource.review.domain.Review;
import com.example.opensource.review.dto.MovieReviewPageDto;
import com.example.opensource.review.dto.ReviewCreateRequestDto;
import com.example.opensource.review.dto.ReviewCreateResponseDto;
import com.example.opensource.review.dto.ReviewDto;
import com.example.opensource.review.repository.MovieRepository;
import com.example.opensource.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository,MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }
    @Override
    public ReviewCreateResponseDto createReview(Long movieId, ReviewCreateRequestDto reviewCreateRequestDto){
        // 영화 조회
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new IllegalArgumentException("영화를 찾을 수 없습니다."));
        // 리뷰 엔티티 생성
        Review review = Review.builder()
                .movie(movie)
                .nickname(reviewCreateRequestDto.getNickname())
                .reviewContents(reviewCreateRequestDto.getReviewContents())
                .build();
        // 리뷰 객체 저장
        Review savedReview = reviewRepository.save(review);
        return ReviewCreateResponseDto.fromEntity(savedReview);
    }
    @Override
    public MovieReviewPageDto findMovieReviews(Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("영화를 찾을 수 없습니다."));

        List<ReviewDto> reviewDtos = movie.getReviews().stream()
                .map(ReviewDto::fromEntity)
                .toList();

        return MovieReviewPageDto.fromEntity(movie, reviewDtos);
    }

}
