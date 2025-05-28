package com.example.opensource.movie.service;

import com.example.opensource.movie.dto.request.MovieByGenreRequestDto;
import org.springframework.http.ResponseEntity;

public interface MovieService {

    ResponseEntity provideMoviesByGenre(MovieByGenreRequestDto movieByGenreRequestDto);

}
