package com.example.opensource.review.dto;

import com.example.opensource.review.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private String nickname;
    private String reviewContents;
    private LocalDateTime createdAt;
    private int score;  //영화 별점

    public static ReviewDto fromEntity(Review review) {
        return ReviewDto.builder()
                .nickname(review.getNickname())
                .reviewContents(review.getReviewContents())
                .createdAt(review.getCreatedAt())
                .score(review.getScore())
                .build();
    }
}