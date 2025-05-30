package com.example.opensource.movie.controller;

import com.example.opensource.movie.dto.request.MovieByCountryRequestDTO;
import com.example.opensource.movie.dto.request.MovieByGenreRequestDto;
import com.example.opensource.movie.service.MovieService;
import com.example.opensource.review.dto.MovieReviewPageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
@Tag(name = "Movie API", description = "영화 관련 API")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "장르별 영화 조회")
    @PostMapping("/by-genre")
    public ResponseEntity lookupMoviesByGenre(@RequestBody MovieByGenreRequestDto movieByGenreRequestDto) {
        return movieService.provideMoviesByGenre(movieByGenreRequestDto);
    }

    @Operation(summary = "국가별 영화 조회")
    @PostMapping("/by-country")
    public ResponseEntity lookuoMovieByCountry(@RequestBody MovieByCountryRequestDTO movieByCountryRequestDTO) {
        return movieService.provideMoviesByCountry(movieByCountryRequestDTO);
    }

    @Operation(summary = "관람평 TOP 10 영화 조회")
    @GetMapping("/top-reviewed")
    public ResponseEntity<List<MovieReviewPageDto>> getTop10ReviewedMovies() {
        return ResponseEntity.ok(movieService.getTop10ReviewedMovies());
    }

    @Operation(summary = "최근 개봉한 영화 조회")
    @GetMapping("/latest")
    public ResponseEntity<List<MovieReviewPageDto>> getLatestReleasedMovies() {
        return ResponseEntity.ok(movieService.getLatestReleasedMovies());
    }


}
