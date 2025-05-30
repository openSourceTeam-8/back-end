package com.example.opensource.movie.service;

import com.example.opensource.common.dto.ResponseForm;
import com.example.opensource.common.handler.ResponseHandler;
import com.example.opensource.movie.dao.MovieRepository;
import com.example.opensource.movie.domain.Movie;
import com.example.opensource.movie.dto.request.MovieByCountryRequestDTO;
import com.example.opensource.movie.dto.request.MovieByGenreRequestDto;
import com.example.opensource.movie.dto.response.FilteredMoviesResponseDTO;
import com.example.opensource.review.domain.Review;
import com.example.opensource.review.dto.MovieReviewPageDto;
import com.example.opensource.review.dto.ReviewDto;
import com.example.opensource.review.dto.response.SummaryReviewResponseDTO;
import com.example.opensource.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public ResponseEntity provideMoviesByGenre(MovieByGenreRequestDto movieByGenreRequestDto) {
        try {
            List<Movie> movies = movieRepository.findByGenre(movieByGenreRequestDto.genre());
            List<FilteredMoviesResponseDTO> response = filterAndConvert(movies);
            return ResponseHandler.create200Response(new ResponseForm(), response);
        } catch (RuntimeException e) {
            return ResponseHandler.create404Error(new ResponseForm(), e);
        } catch (Exception e) {
            return ResponseHandler.create500Error(new ResponseForm(), e);
        }
    }

    @Override
    public ResponseEntity provideMoviesByCountry(MovieByCountryRequestDTO movieByCountryRequestDTO) {
        try {
            List<Movie> movies = movieRepository.findByNation(movieByCountryRequestDTO.country());
            List<FilteredMoviesResponseDTO> response = filterAndConvert(movies);
            return ResponseHandler.create200Response(new ResponseForm(), response);
        } catch (RuntimeException e) {
            return ResponseHandler.create404Error(new ResponseForm(), e);
        } catch (Exception e) {
            return ResponseHandler.create500Error(new ResponseForm(), e);
        }
    }

    private List<FilteredMoviesResponseDTO> filterAndConvert(List<Movie> movies) {
        return movies.stream()
                .map(movie -> {
                    Review latestReview = reviewRepository.findFirstByMovieOrderByCreatedAtDesc(movie)
                            .orElse(null);

                    SummaryReviewResponseDTO summaryReview = latestReview != null
                            ? SummaryReviewResponseDTO.builder()
                            .score(latestReview.getScore())
                            .comment(latestReview.getReviewContents())
                            .build()
                            : null;

                    return FilteredMoviesResponseDTO.from(movie, summaryReview);
                })
                .toList();
    }
    public List<MovieReviewPageDto> getTop10ReviewedMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .map(movie -> {
                    List<ReviewDto> reviewDtos = movie.getReviews().stream()
                            .map(ReviewDto::fromEntity)
                            .toList();

                    return MovieReviewPageDto.fromEntity(movie, reviewDtos);
                })
                .sorted(Comparator.comparingDouble(MovieReviewPageDto::getAvgScore).reversed())
                .limit(10)
                .toList();
    }

    public List<MovieReviewPageDto> getLatestReleasedMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .sorted(Comparator.comparing(Movie::getReleaseYear).reversed())
                .map(movie -> {
                    List<ReviewDto> reviewDtos = movie.getReviews().stream()
                            .map(ReviewDto::fromEntity)
                            .toList();

                    return MovieReviewPageDto.fromEntity(movie, reviewDtos);
                })
                .toList();
    }

}