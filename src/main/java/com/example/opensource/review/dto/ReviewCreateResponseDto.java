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
public class ReviewCreateResponseDto {  //리뷰 작성 후 화면에 표시되는 내용
    private LocalDateTime createdAt;
    private String nickname;
    private String reviewContents;
    private int score;  //영화 별점

    // Review 엔티티를 ReviewCreateResponseDto로 변환
    public static ReviewCreateResponseDto fromEntity(Review review) {
        return ReviewCreateResponseDto.builder()
                .createdAt(review.getCreatedAt())
                .nickname(review.getNickname())
                .reviewContents(review.getReviewContents())
                .score(review.getScore())
                .build();
    }
}
