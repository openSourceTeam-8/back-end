package com.example.opensource.movie.service;

import com.example.opensource.common.dto.ResponseForm;
import com.example.opensource.common.handler.ResponseHandler;
import com.example.opensource.movie.dao.MovieRepository;
import com.example.opensource.movie.domain.Movie;
import com.example.opensource.movie.dto.request.MovieByGenreRequestDto;
import com.example.opensource.movie.dto.response.MovieByGenreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public ResponseEntity provideMoviesByGenre(MovieByGenreRequestDto movieByGenreRequestDto) {
        try {
            String genre = movieByGenreRequestDto.genre();

            List<Movie> movies = movieRepository.findByGenre(genre);

            List<MovieByGenreResponseDTO> response = movies.stream()
                    .map(MovieByGenreResponseDTO::from)
                    .toList();

            return ResponseHandler.create200Response(new ResponseForm(), response);
        } catch (RuntimeException e) {
            return ResponseHandler.create404Error(new ResponseForm(), e);
        } catch (Exception e) {
            return ResponseHandler.create500Error(new ResponseForm(), e);
        }
    }

}
