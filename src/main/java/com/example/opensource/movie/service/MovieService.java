package com.example.opensource.movie.service;

import com.example.opensource.movie.dto.request.MovieByCountryRequestDTO;
import com.example.opensource.movie.dto.request.MovieByGenreRequestDto;
import com.example.opensource.review.dto.MovieReviewPageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    ResponseEntity provideMoviesByGenre(MovieByGenreRequestDto movieByGenreRequestDto);

    ResponseEntity provideMoviesByCountry(MovieByCountryRequestDTO movieByCountryRequestDTO);

    List<MovieReviewPageDto> getTop10ReviewedMovies();
    List<MovieReviewPageDto> getLatestReleasedMovies();
}
