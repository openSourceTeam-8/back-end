package com.example.opensource.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateRequestDto {
    private String nickname; // 리뷰 작성자 닉네임
    private String reviewContents; // 작성할 리뷰 내용
    private int score;  //영화 별점
}
