package com.example.opensource.review.dto;

import com.example.opensource.movie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieReviewPageDto {
    private String title;   //영화제목
    private LocalDate releaseYear;  //개봉년도
    private String showtime;    //상영시간
    private String genre;   //장르
    private String nation;  //국가
    private String cast;    //출연진
    private String director;    //감독
    private String movieRating; //등급(전체관람가,12세,..)
    private int reviewCount;    //리뷰 개수
    private List<String> thumbnails;    //썸네일(영화포스터)
    private List<ReviewDto> reviews;  //리뷰

    public static MovieReviewPageDto fromEntity(Movie movie, List<ReviewDto> reviewDtos) {
        return MovieReviewPageDto.builder()
                .title(movie.getTitle())
                .releaseYear(movie.getReleaseYear())
                .showtime(movie.getShowtime())
                .genre(movie.getGenre())
                .nation(movie.getNation())
                .cast(movie.getCast())
                .director(movie.getDirector())
                .movieRating(movie.getMovieRating().name())
                .reviewCount(reviewDtos.size())
                .thumbnails(
                        movie.getThumbnails().stream()
                                .map(thumbnail -> thumbnail.getUrl())
                                .toList()
                )
                .reviews(reviewDtos)
                .build();
    }
}
