package com.example.opensource.review.domain;

import com.example.opensource.movie.domain.Movie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Lob
    @Column(name = "review_contents", nullable = false)
    private String reviewContents;
    //영화 별점 추가
    @Column(nullable=false)
    private int score;  //별점은 정수로, 평균은 실수(소수점 2번째 자리까지)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

}
